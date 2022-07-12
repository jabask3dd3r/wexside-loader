// ====== LAUNCHER CONFIG ====== //
var config = {
    dir: "wexside", // Launcher directory
    title: "WEXSIDE", // Window title
    icons: [ "favicon.png" ], // Window icon paths

    // Auth config
    newsURL: "https://vk.com/wexsidehack", // News WebView URL
    linkText: "Забыли пароль?", // Text for link under "Auth" button
    linkURL: new java.net.URL("https://vk.com/wexsidehack"), // URL for link under "Auth" button

    // Settings defaults
    settingsMagic: 0xC0DE5, // Ancient magic, don't touch
    autoEnterDefault: false, // Should autoEnter be enabled by default?
    fullScreenDefault: false, // Should fullScreen be enabled by default?
    ramDefault: 1024, // Default RAM amount (0 for auto)

    // Custom JRE config (!!! DON'T CHANGE !!!)
    jvmMustdie32Dir: "jre-8u282-win32", jvmMustdie64Dir: "jre-8u282-win64",
    jvmLinux32Dir: "jre-8u282-linux32", jvmLinux64Dir: "jre-8u282-linux64",
    jvmMacOSXDir: "jre-8u282-macosx", jvmUnknownDir: "jre-8u282-unknown"
};

// ====== DON'T TOUCH! ====== //
var dir = IOHelper.HOME_DIR.resolve(config.dir);
if (JVMHelper.OS_TYPE == JVMHelperOS.MUSTDIE)
{
    dir = IOHelper.HOME_DIR_WIN.resolve(config.dir);
}
if (!IOHelper.isDir(dir)) {
    java.nio.file.Files.createDirectory(dir);
}
var defaultUpdatesDir = dir.resolve("updates");
if (!IOHelper.isDir(defaultUpdatesDir)) {
    java.nio.file.Files.createDirectory(defaultUpdatesDir);
}
