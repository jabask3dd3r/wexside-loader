/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.core.Filter
 *  org.apache.logging.log4j.core.Layout
 *  org.apache.logging.log4j.core.LogEvent
 *  org.apache.logging.log4j.core.appender.AbstractAppender
 *  org.apache.logging.log4j.core.config.plugins.Plugin
 *  org.apache.logging.log4j.core.config.plugins.PluginAttribute
 *  org.apache.logging.log4j.core.config.plugins.PluginElement
 *  org.apache.logging.log4j.core.config.plugins.PluginFactory
 *  org.apache.logging.log4j.core.layout.PatternLayout
 */
package com.mojang.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

@Plugin(name="Queue", category="Core", elementType="appender", printObject=true)
public class SourceFile1
extends AbstractAppender {
    private static final int MAX_CAPACITY = 250;
    private static final Map QUEUES = new HashMap();
    private static final ReadWriteLock QUEUE_LOCK = new ReentrantReadWriteLock();
    private final BlockingQueue queue;

    public SourceFile1(String string, Filter filter, Layout layout, boolean bl, BlockingQueue blockingQueue) {
        super(string, filter, layout, bl);
        this.queue = blockingQueue;
    }

    public void append(LogEvent logEvent) {
        if (this.queue.size() >= 250) {
            this.queue.clear();
        }
        this.queue.add(this.getLayout().toSerializable(logEvent).toString());
    }

    @PluginFactory
    public static SourceFile1 createAppender(@PluginAttribute(value="name") String string, @PluginAttribute(value="ignoreExceptions") String string2, @PluginElement(value="Layout") Layout layout, @PluginElement(value="Filters") Filter filter, @PluginAttribute(value="target") String string3) {
        boolean bl = Boolean.parseBoolean(string2);
        if (string == null) {
            LOGGER.error("No name provided for QueueLogAppender");
            return null;
        }
        if (string3 == null) {
            string3 = string;
        }
        QUEUE_LOCK.writeLock().lock();
        LinkedBlockingQueue linkedBlockingQueue = (LinkedBlockingQueue)QUEUES.get(string3);
        if (linkedBlockingQueue == null) {
            linkedBlockingQueue = new LinkedBlockingQueue();
            QUEUES.put(string3, linkedBlockingQueue);
        }
        QUEUE_LOCK.writeLock().unlock();
        if (layout == null) {
            layout = PatternLayout.newBuilder().build();
        }
        return new SourceFile1(string, filter, layout, bl, linkedBlockingQueue);
    }

    public static String getNextLogEvent(String string) {
        QUEUE_LOCK.readLock().lock();
        BlockingQueue blockingQueue = (BlockingQueue)QUEUES.get(string);
        QUEUE_LOCK.readLock().unlock();
        if (blockingQueue != null) {
            try {
                return (String)blockingQueue.take();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        return null;
    }
}

