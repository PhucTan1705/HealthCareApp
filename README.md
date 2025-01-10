# Language
[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/PhucTan1705/grocery_app/blob/master/README.md)
[![vn](https://img.shields.io/badge/lang-vn-red.svg)](https://github.com/PhucTan1705/grocery_app/blob/master/README.VN.md)

---
# The HealthCare App

## Overview:

An integrated healthcare application with multiple features, allowing users to easily register and create an account to perform activities such as ordering medicine online, accessing detailed health information, 
scheduling appointments with doctors, and quickly staying updated with useful medical news...
<div align="center">
  <span><kbd><img src="https://drive.google.com/uc?export=view&id=1c6WeQpqzViW-3M40Gq0hfdwCNHw01fbu" width="300" height="530"  hspace="10"></kbd></span>
  <span><kbd><img src="https://drive.google.com/uc?export=view&id=1Lg5-IUjwgSIMzOB6nbK_dOalhw6DRF64" width="300" height="530"  hspace="10"></kbd></span>
  <span><kbd><img src="https://drive.google.com/uc?export=view&id=1WGZhbed6K_1I2bA6tk2YKrG1Rpux8bOY" width="300" height="530"  hspace="10"></kbd></span>
  <span><kbd><img src="https://drive.google.com/uc?export=view&id=1twCk7_bKgGghP9elLY_mL37js4KT370f" width="300" height="530"  hspace="10"></kbd></span>
</div>

## Installation:

### 1. Razorpay:

Install the Razorpay Java SDK and integrate it with your Java-based website, app to accept payments, initiate refunds and much more.

[Learn more](https://razorpay.com/docs/payments/)

#### Getting started with Razorpay:

If you are new to Razorpay, you can create a Razorpay account right from the mobile app. If you are an existing Razorpay user, log in to the Razorpay Payments Mobile app using your Razorpay Dashboard credentials.

[Learn more](https://razorpay.com/docs/payments/mobile-app/get-started/#create-a-new-account)

#### Dependencies:

- You must use Java v15 or higher. Know more about the [latest java versions](https://www.java.com/releases/)
- Import the following packages before your get started:

```
import org.json.JSONObject;
import com.razorpay.*;
```

#### Installation:

- You can install Razorpay using Gradle:
  + Download and [Install Gradle](https://gradle.org/install/) on your system.
- Download the latest [Source code](https://github.com/razorpay/razorpay-java/releases) zip file from the Releases section of GitHub.
- Unzip the file and add this dependency to the build file of the project:

```
implementation 'com.razorpay:razorpay-java:x.y.z" //x.y.z = the version you want to install
```

[Learn more](https://razorpay.com/docs/payments/server-integration/java/)

### 2. Getting started with SQLite:

SQLite is an in-process library that implements a self-contained, serverless, zero-configuration, transactional SQL database engine. The code for SQLite is in the public domain and is thus free for use for any purpose, commercial or private. SQLite is the most widely deployed database in the world with more applications than we can count, including several high-profile projects.

[Learn more](https://www.sqlite.org/about.html)

[Documentation](https://www.sqlite.org/docs.html)

### 3. Set Up SQLite:

#### Install SQLite:

- Step 1 − Go to SQLite [Download Page](https://www.sqlite.org/download.html), and download precompiled binaries from Windows section.
- Step 2 − Download sqlite-tools-win-x64.zip and sqlite-dll-win-x64.zip zipped files.
- Step 3 − Create a folder C:\>sqlite and unzip above two zipped files in this folder, which will give you sqlite3.def, sqlite3.dll and sqlite3.exe files.
- Step 4 − Add C:\>sqlite in your PATH environment variable and finally go to the command prompt and issue sqlite3 command, which should display the following result:

```
C:\>sqlite3
SQLite version 3.7.15.2 2013-01-09 11:53:05
Enter ".help" for instructions
Enter SQL statements terminated with a ";"
sqlite>
```

