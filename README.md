# QUESTION1(PYTHON ASSIGNMENT)-Hardware Information System

## Overview
This project is a Python-based hardware information utility that displays real-time system hardware details in JSON format using Object-Oriented Programming (OOP) concepts.

The application automatically detects the operating system and fetches hardware information in JSON format.

---

## Features
- Automatic operating system detection
- Real-time hardware information display
- JSON formatted output
- Abstract class implementation
- Linux and Windows support
- Modular package structure
- Object-Oriented Programming concepts

---

## Technologies Used
- Python 3
- psutil
- socket
- platform
- json

---

## Project Structure

```text
HardwareInfoProject/
│
├── main.py
├── requirements.txt
├── README.md
├── .gitignore
│
├── hosts/
│   ├── __init__.py
│   ├── host_info.py
│   ├── linux_host.py
│   └── windows_host.py
│
└── screenshots/
    └── output.png
```

---

## OOP Concepts Used

### Inheritance
`LinuxHost` and `WindowsHost` inherit from `HostInfo`.

### Abstraction
`HostInfo` contains the abstract method:

```python
get_hardware_info()
```

### Polymorphism
Both child classes implement hardware information retrieval differently.

### Encapsulation
Hardware details are stored as class attributes.

---

## Installation

```bash
pip install -r requirements.txt
```

---

## Run Application

```bash
python main.py
```

---





# QUESTION 2(JAVA ASSIGNMENT) -Log File Parser

## Overview

This Java application parses log files and displays the most recent logs based on log type and number of lines.

Supported log types:
- error
- warning
- info
- debug

---

## Features

- Reads log file from end
- Displays latest matching logs
- Supports multiple log types
- Exception handling included

---

## Project Structure

LogFileParser/
│
├── LogParser.java
├── sample.log
├── README.md
└── screenshots/

---

## Compile

```bash
javac LogParser.java
```

## Run

```bash
java LogParser sample.log
```

```bash
java LogParser sample.log 10 error,info
```

```bash
java LogParser sample.log 5 debug
```

---

## Exception Handling

### Invalid File

```bash
java LogParser wrong.log
```

### Invalid Log Type

```bash
java LogParser sample.log 5 invalid
```
