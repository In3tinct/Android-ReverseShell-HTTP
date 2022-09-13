# Android Reverse Shell Over HTTP
While working on a project, Metasploit HTTP reverse shell was crashing, so i decided to write this project for anyone who would need to generate a malicious apk for testing (authorized) or learning Android Security. It sends over a reverseshell over HTTP tunnel. Future extensions may include HTTPS too.

#### 1) Import this project into Android Studio and Change the below lines for configuring your hostname to get reverse shell
 
 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/java/com/example/hell0/Shello.java#L72

 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/java/com/example/hell0/Shello.java#L36

 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/res/xml/network_security_config.xml#L4

#### 2) Build the project and generate APK

#### 3) Run a server for reverse shell to connect back.
https://github.com/In3tinct/Information-Security/blob/master/Python-Server-For-ReverseShell/pythonserver.py

python3 pythonserver.py

#### 4) Transfer the APK to the device and let it run and wait for reverse shell.

![Screen Shot 2022-08-30 at 10](https://user-images.githubusercontent.com/18059590/187598627-a6835a6e-c8b3-40b7-a5eb-62aa3459b46a.png)

I've used multiple online sources to built this project.

Twitter - https://twitter.com/_In3tinct


