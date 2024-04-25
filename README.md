# README

This repository illustrates the tool, data, and scripts of our Internetware2024 under-reviewing work --  `DepCQC : Dependency-enhanced Code Quality Check for Java`.

## Directory Structure

The whole directory tree goes like the following:

```
│  README.md
│
├─Data
│  ├─Results
│  │  ├─RQ1
│  │  │  ├─DepCQCResult
│  │  │  └─TestCase
│  │  ├─RQ2
│  │  │  └─open-source
│  │  │      ├─apache-ant-1.8.4
│  │  │      ├─apache-jmeter-2.9
│  │  │      ├─castor-1.3.1
│  │  │      ├─displaytag-1.2
│  │  │      ├─freecs-1.3.20100406
│  │  │      ├─JSPWiki-2.8.4-src
│  │  │      ├─poi-3.6
│  │  │      └─Vuze_4812_source
│  │  ├─RQ3
│  │  └─RQ4
│  └─Setup
├─Method
│  └─DepCQC
│      ├─bin
│      └─lib
└─Scripts
    ├─RQ2
    └─RQ4
```



## Method

### DepCQC

`DepCQC.xml` is provided in a format that can be directly used as a ruleset.

`Rule.csv` contains detailed descriptions of the rules we have implemented.

### Requirements

- Operating System : *Windows* / *Linux* .
- `Java Runtime Environment (JRE)` or `Java Development Kit (JDK)` version 17 or higher.

### Usage

To use `DepCQC`, run the script from the command line, specifying the necessary arguments. Here is a breakdown of the available arguments:

```less
usage: DepCQC.bat [-H][-h][-help] [-d SOURCE_PROJECT_DIRECTORY] [-f OUTPUT_FORMAT] [-R RULESET_OR_RULE_REFERENCES] [-r OUTPUT] [-t THE_NUMBER_OF_THREADS] 

arguments:
`-dir` , `-d`: Required Root directory for the analyzed sources.
`-format`, `-f`: Output format of the analysis report.
`-rulesets`, `-R`: Required Comma-separated list of ruleset or rule references.
`-reportfile `, `-r`: Path to a file in which the report output will be sent. By default the report is printed on standard output.
`-threads`, `-t`: Sets the number of threads used by DepCQC. Set threads to 0 to disable multi-threading processing.

eaxmple usage:
Windoes:
bin\DepCQC.bat \\
  -d D:\zqyyfjzone-master \\
  -f xml 
  -R D:\rulesets\java\DepCQC.xml \\
  -r D:\Test\zqyyfjzone-master.xml
  -t 4
Linux:
bin/run.sh \
  -d D:/zqyyfjzone-master \
  -f xml \
  -R D:/rulesets/java/DepCQC.xml \
  -r D:/Test/zqyyfjzone-master.xml \
  -t 0
```

`DepCQC` supports output file formats like csv, xml, html, and others.

`database.properties` contains database connection details such as URL, username, and password, as well as information about file upload and download methods: either Minio or S3, along with related settings.

### return value

| Exit Status | Corresponding explanations                                   |
| ----------- | ------------------------------------------------------------ |
| 0           | Everything is fine, no violations found                      |
| 1           | Couldn't understand command-line parameters or DepCQC exited with an exception |
| 4           | At least one violation has been detected                     |

## Data

### Setup

This folder contains the initial data for the project needed to run the four RQs of the experiment.

- `ProjectScale.csv`: Contains files , blanks , comments and code information for open-source and closed-source projects.

### Results

### RQ1: What is the effectiveness of DepCQC to detect violations against the micro-benchmark?

All files or directories mentioned below are in [Data/Results/RQ1](Data/Results/RQ1).

- The  `TestCase` folder contains test cases for RQ1, where "// Compliant" and "// Noncompliant" are used in the code to denote positive and negative instances, respectively.
- The `DepCQCResult` folder contains the results of running RQ1 cases with DepCQC.
- `RQ1.csv` contains the results of RQ1, including TP, TN, FP, FN, Recall, Precision, and F1 Score for different rulesets.

### RQ2. What is the effectiveness of DepCQC to detect violations on real-world projects?

- The `open-source` folder contains 8 subfolders for different open-source projects. Each project subdirectory contains 3 CSV files:
  - `projectName_benchmark.csv`: BenchMarks manually curated by us.
  - `projectName_DepCQC.csv`: Results of DepCQC execution.
  - `projectName_Sonar.csv`: Results of SonarQube execution.
- The file `RQ2.csv` contains the Recall, Precision, and F1 Score calculated against the BenchMark for both DepCQC and SonarQube, including evaluations on both open-source and closed-source projects.

### RQ3. What are the major reasons for violation detection failures?

The file `RQ3.csv` contains detailed counts of false negatives and false positives for both open-source and closed-source projects.

### RQ4. What are the differences in quality issues indicated by DepCQC between open-source projects and closed-source ones?·

`RQ4.csv` presents the results of normalization and comprehensive calculation of various metrics across dimensions such as Complexity, Size, Security, Reliability, Maintainability, and Issue.

## Scripts

### RQ2

- `rule_mapping.csv` is used  as the rule mapping table between DepCQC and SonarQube.
- `match_rulekey.py` is used to add mapping relationships between SonarQube scan results and DepCQC.
- `compare.py` is used to compare the results of BenchMark, SonarQube, and DepCQC, providing the FP, FN , and TP for both tools, which are used for the subsequent Recall, Precision, and F1 Score calculations.

### RQ4

- `hotmap.py`  is used to visualize metrics across multiple dimensions on both open-source and closed-source projects.