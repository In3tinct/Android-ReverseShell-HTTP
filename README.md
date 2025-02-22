# Android Reverse Shell Over HTTP
While working on a project, Metasploit HTTP reverse shell was crashing, so i decided to write this project for anyone who would need to generate a malicious apk for testing (authorized) or learning Android Security. It sends over a reverseshell over HTTP tunnel. Future extensions may include HTTPS too.

## Steps to Run

1) Clone the github repo and Import this project into Android Studio. Change the below lines for configuring your hostname to get reverse shell.
 
 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/java/com/example/hell0/Shello.java#L72

 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/java/com/example/hell0/Shello.java#L36

 https://github.com/In3tinct/Android-ReverseShell-HTTP/blob/main/app/src/main/res/xml/network_security_config.xml#L4

2) Build the project and generate APK.

3) Run a server for reverse shell to connect back.
https://github.com/In3tinct/Information-Security/blob/master/Python-Server-For-ReverseShell/pythonserver.py

python3 pythonserver.py

4) Transfer the generated APK to the device and run it, wait for reverse shell.

![Screen Shot 2022-08-30 at 10](https://user-images.githubusercontent.com/18059590/187598627-a6835a6e-c8b3-40b7-a5eb-62aa3459b46a.png)

I've used multiple online sources to built this project.

## Citation
Please cite, If you use this software in your Research papers, articles etc.

```
@software{Agrawal_Android-ReverseShell-HTTP_Research_project_2022,
author = {Agrawal, Vaibhav},
month = aug,
title = {{Android-ReverseShell-HTTP: Research project for Android Security}},
url = {https://github.com/In3tinct/Android-ReverseShell-HTTP},
version = {1.0.0},
year = {2022}
}
```
## License
Apache 2.0; see [`LICENSE`](LICENSE) for details.

## Disclaimer
This is an experimental project and the owner of this project shall not be held liable for any actions performed using this tool. It is the sole responsibility of the end-user.

