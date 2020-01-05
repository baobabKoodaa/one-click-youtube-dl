This is a small tool that provides a "one click download" functionality to youtube-dl on Windows.

**Prerequisites:**

1. Java: Download [Java JDK](https://jdk.java.net/), add it to environment path variable
2. ffmpeg: Download [ffmpeg Windows build](https://www.ffmpeg.org/download.html#build-windows),
add it to environment path variable

**Installation:**

1. Download [youtube-dl Windows executable](https://ytdl-org.github.io/youtube-dl/download.html)
2. Test that you are able to download high-quality videos from youtube on command line
(e.g. run `youtube-dl https://youtube.com/somevideo` in the folder where the youtube-dl executable is,
after download is finished check that the quality is good. If quality is bad, it's probably unable
to call ffmpeg)
3. Download the [build files of this tool](https://github.com/baobabKoodaa/one-click-youtube-dl/releases)
(a `.zip` which contains a `.jar` and a `.bat`)
4. Place the youtube-dl executable and the build files of this tool into the folder where you want
to download youtube videos

**Usage:**

1. Copy the URL of the video you want to download to clipboard (CTRL+C).
2. Run `one-click-youtube-dl.bat`

That's it! youtube-dl is now downloading the video from the URL in the clipboard.

**Why does this exist?**

I used to use youtube-dl via command line, but it quickly became a chore. Then I started using youtube-dl-gui,
which reduced manual typing and did the job, but had its faults.

My main gripe with it is that it doesn't offer one-click downloads. You have to open the program,
click on the paste field, right-click, select paste, add pasted url to queue, and then click download.
So the GUI is forcing you to do 6 clicks to download a single video.

My other gripe is that the GUI is
actively supressing warnings and errors. When something goes wrong, the fault is actively hidden from
the user so the user has no possibility to fix the problem. I recently experienced a scenario
where youtube-dl-gui was unable to download any videos, and instead of showing some kind of error, the message
it was showing in the GUI was "finished" (as in, the download 'finished' successfully, when in fact it failed
to download anything at all). In contrast to youtube-dl-gui, this tool simply opens youtube-dl in a command
prompt and keeps the window open so you can see all the output that youtube-dl gives.

**Why Java, couldn't this be a simple bash script?**

Sure, why not. I just don't have experience writing Windows bash scripts and I don't know how to do URL validation
with bash. If you just had a simple bash script to run youtube-dl without URL validation, you would run the risk of running arbitrary
bash commands from clipboard (if you accidentally had something in clipboard that you shouldn't have) -- so URL validation is important. It only took a few seconds to write rudimentary URL
validation with Java, so I minimized my own time by writing this in a language that's familiar to me. The downside of this choice is
that users need Java to run this, but then again, the type of people who are likely to use this are developers
who already have Java on their machine, so it's not really an issue.