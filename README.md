# Android-ReverseShell-OverHTTP

1) Import this project into Android Studio and Change the below lines for configuring your hostname to get reverse shell
 
 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/java/com/example/hell0/Shello.java#L72

 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/java/com/example/hell0/Shello.java#L36

 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/res/xml/network_security_config.xml#L4

2) Build the project and generate APK

3) Run a server for reverse shell to connect back.
https://github.com/In3tinct/Information-Security/blob/master/Python-Server-For-ReverseShell/pythonserver.py

python3 pythonserver.py

4) Transfer the APK to the device and let it run and wait for reverse shell.

This is not entirely my code, i have used bits and pieces from various sources.

Twitter - https://twitter.com/_In3tinct
