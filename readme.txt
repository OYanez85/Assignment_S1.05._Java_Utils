# Assignment_S1.05._Java_Utils

## 📄 Description

This project consists of Java utilities organized across three levels, each implementing various file management, configuration, and encryption functionalities. The exercises cover directory listing, file reading/writing, object serialization, configuration parameterization, and encryption. All exercises are designed to be run from the command line, and all commands and structure have been created using the Linux Debian command line.

## 💻 Technologies Used

- **Java SE Development Kit (JDK)**: Version 11 or higher
- **Eclipse IDE or IntelliJ IDEA**: IDEs for writing and managing Java code
- **Git/GitHub**: For version control and repository management

## 📋 Requirements

- **Java SE Development Kit (JDK)**: Version 11 or higher
- **Integrated Development Environment (IDE)**: Eclipse or IntelliJ IDEA
- **Git**: To clone the repository and manage version control

## 🛠️ Installation

Clone the repository:

```bash
git clone https://github.com/OYanez85/Assignment_S1.05._Java_Utils.git
Open the project in IntelliJ IDEA or Eclipse:

IntelliJ: Go to File -> Open and select the cloned project directory.
Eclipse: Use File -> Import -> Git -> Projects from Git, then select the cloned directory.
Ensure that JDK 11 or higher is set up in your IDE:

IntelliJ IDEA: Go to File -> Project Structure -> Project SDK and select JDK 11.
Eclipse: Go to Window -> Preferences -> Java -> Installed JREs and ensure JDK 11 is set.

## ▶️ Execution

All exercises can be run from the command line. Each exercise should be compiled first and then executed using the provided commands. Ensure you are in the main project directory before running the commands.

Level 1

Exercise 1: List the contents of a directory in alphabetical order.

javac -d Level_1/bin Level_1/Exercise_1/ListDirectory.java
java -cp Level_1/bin Exercise_1.ListDirectory /path/to/directory
Exercise 2: Recursively list directory contents in alphabetical order, indicating file type and last modification date.

javac -d Level_1/bin Level_1/Exercise_2/DirectoryTree.java
java -cp Level_1/bin Exercise_2.DirectoryTree /path/to/directory
Exercise 3: Save the recursive directory listing from Exercise 2 to a TXT file.

javac -d Level_1/bin Level_1/Exercise_3/DirectoryTreeToFile.java
java -cp Level_1/bin Exercise_3.DirectoryTreeToFile /path/to/directory /path/to/output.txt
Exercise 4: Read a TXT file and display its contents.

javac -d Level_1/bin Level_1/Exercise_4/ReadTxtFile.java
java -cp Level_1/bin Exercise_4.ReadTxtFile /path/to/file.txt
Exercise 5: Serialize and deserialize a Java object.

javac -d Level_1/bin Level_1/Exercise_5/SerializeObject.java Level_1/Exercise_5/MyObject.java
java -cp Level_1/bin Exercise_5.SerializeObject /path/to/object.ser serialize
java -cp Level_1/bin Exercise_5.SerializeObject /path/to/object.ser deserialize

Level 2

Exercise 1: Run Exercise 3 from Level 1 with parameters defined in a configuration file (config/config.properties).

javac -d Level_2/bin Level_2/Exercise_1/ConfigurableDirectoryTree.java
java -cp Level_2/bin Exercise_1.ConfigurableDirectoryTree

Ensure config/config.properties contains:

properties

directory=/path/to/directory
outputFile=/path/to/output.txt

Level 3

Exercise 1: Encrypt and decrypt files using AES algorithm.

javac -d Level_3/bin Level_3/Exercise_1/EncryptDecryptUtility.java

Encrypt a file:

java -cp Level_3/bin Exercise_1.EncryptDecryptUtility /path/to/input.txt /path/to/encrypted_output.txt encrypt

Decrypt a file:

java -cp Level_3/bin Exercise_1.EncryptDecryptUtility /path/to/encrypted_output.txt /path/to/decrypted_output.txt decrypt

## 🌐 Deployment

This project is designed to be executed locally and doesn’t require server deployment. However, if needed, you can package it as a JAR file using tools like Maven or Gradle for easy distribution.

## 🤝 Contributions

Fork the repository on GitHub.

Create a new branch for your changes:

git checkout -b feature/your-feature-name
Make changes and commit:

git add .
git commit -m "Your commit message"

Push your branch:

git push origin feature/your-feature-name
Create a pull request to merge your changes.
