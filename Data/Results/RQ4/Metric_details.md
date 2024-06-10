

## **Efficiency** Dimension
Data derived from static code analysis scan results and Java parsing methods.

- **Classes**
  - **Definition:** Total number of classes in the project.

- **Comment Lines**
  - **Definition:** Total number of comment lines in the project.

- **Comment Line Density**
  - **Definition:** Percentage of total code lines that are comments.

- **Directories**
  
  - **Definition:** Total number of directories in the project.
  
- **Files**
  - **Definition:** Total number of files in the project.

- **Functions**
  - **Definition:** Total number of functions/methods in the project.

- **Lines**
  - **Definition:** Total number of lines including code, comments, and blanks.

- **Lines of Code (LOC)**
  - **Definition:** Total number of effective code lines, excluding blanks and comments.

- **Statements**
  - **Definition:** Total number of executable statements in the project.
  
- **Complexity (Cyclomatic Complexity)**

  - **Definition:** Measures the complexity of the project's code, specifically the number of independent paths through a program.
  - **Calculation Method:** Sum of complexities analyzed for each file, where each method contributes to the file's total complexity.

- **ACC(Average Class Complexity)**

  - *Definition:** Average Class Complexity (ACC) measures the average complexity across all classes in a software system. This metric gives a good indication of how complex the classes are on average, which can be a crucial factor in assessing the maintainability and understandability of the code.
  - **Calculation Method:**

  ```
  ACC = Total Cyclomatic Complexity of all methods in a class / Number of classes
  ```

- **CR(Complexity Rating)**

  - **Definition:** Complexity Rating (CR) is a classification that assesses the overall complexity of classes in a software system based on the average complexity per class. This rating helps to categorize classes into different complexity levels, which can inform decisions about refactoring, testing, and maintenance priorities.

  - **Calculation Method:** The Complexity Rating (CR) is determined by evaluating the Average Class Complexity (ACC) according to the following scale:

    - **CR = A** if ACC is less than or equal to 10

    - **CR = B** if ACC is greater than 10 and less than or equal to 20

    - **CR = C** if ACC is greater than 20 and less than or equal to 40

    - **CR = D** if ACC is greater than 40 and less than or equal to 50

    - **CR = E** if ACC is greater than 50


## Reliability Dimension
- **Bugs**
  - **Definition:** Total number of bugs identified in the code.
  - **Calculation Method:** Detected through specific rules aimed at identifying potential errors and code style issues.

- **New Bugs**
  - **Definition:** Total number of new bugs identified in the newly added code.
  - **Calculation Method:** Detection based on specific rules from the latest scans.

- **Reliability Rating**
  - **Definition:** Rating derived after classifying the severity of bugs found.
    - A = 0 Bugs
    - B = At least 1 Minor Bug
    - C = At least 1 Major Bug
    - D = At least 1 Critical Bug
    - E = At least 1 Blocker Bug

- **Reliability Rating on New Code**
  - **Definition:** Reliability rating for newly added code, following the same criteria.

- **Reliability Remediation Effort**
  - **Definition:** Effort required to address all identified bugs.
  - **Calculation Method:** Estimated in minutes, stored in the database, assuming an 8-hour workday.

- **Reliability Remediation Effort on New Code**
  - **Definition:** Effort required to address bugs found in new code.

## Security Dimension
- **Vulnerabilities**
  - **Definition:** Total number of security vulnerabilities identified.
  - **Calculation Method:** Detected through specific rules aimed at identifying potential security flaws.

- **New Vulnerabilities**
  - **Definition:** Total number of new vulnerabilities found in the newly added code.

- **Security Rating**
  - **Definition:** Security rating based on the severity of vulnerabilities identified.
    - A = 0 Vulnerabilities
    - B = At least 1 Minor Vulnerability
    - C = At least 1 Major Vulnerability
    - D = At least 1 Critical Vulnerability
    - E = At least 1 Blocker Vulnerability

- **Security Rating on New Code**
  - **Definition:** Security rating for newly added code using the same criteria.

- **Security Remediation Effort**
  - **Definition:** Effort required to remediate all identified security vulnerabilities.

- **Security Remediation Effort on New Code**
  - **Definition:** Effort required to address new security vulnerabilities found in new code.

## Maintainability Dimension
Analysis of maintainability issues identified through static code analysis.

- **Code Smells**
  - **Definition:** Total number of code smell issues identified in the code.
  - **Calculation Method:** Identified by specific rules designed to detect a range of code style and potential error issues. The total is computed by counting occurrences classified as code smells.

- **Code Smells on New Code**
  - **Definition:** Total number of code smell issues first identified in newly added code.
  - **Calculation Method:** Detected using specific rules, with the total computed by counting new occurrences classified as code smells.

- **Technical Debt**
  - **Definition:** Quantified effort required to address all identified code smells, measured in minutes and stored in the database. Assumed to be an 8-hour workday when calculated in days.
  - **Calculation Method:** Most issues come with an estimated remediation cost (time to fix). The total remediation cost for all code smells equates to the technical debt.

- **Technical Debt on New Code**
  - **Definition:** Measure of effort required to fix all code smells first identified in new code.
  - **Calculation Method:** The total remediation cost for new code smells equates to the technical debt, calculated in the same manner as existing code.

- **Technical Debt Ratio**
  - **Definition:** Ratio between the cost of developing the software and the cost to fix it.
  - **Calculation Method:** Technical debt ratio is calculated as follows:
    ```
    Technical Debt Ratio = Remediation Cost / (Cost per Line of Code * Number of Lines of Code)
    ```

  Note: The default cost to develop one line of code is 0.06 days, equivalent to 30 minutes. This cost refers to the expense required to rewrite the code from scratch.
  
- **Technical Debt Ratio on New Code**
  
  - **Definition:** Ratio between the development cost of new code and the associated remediation cost.
  - **Calculation Method:** Similar to the overall technical debt ratio.
  
- **Maintainability Rating (SQALE Rating)**
  - **Definition:** Rating associated with the technical debt ratio.
  - **Calculation Method:** Based on the following scale:
    - A = 0-0.05
    - B = 0.06-0.1
    - C = 0.11-0.20
    - D = 0.21-0.5
    - E = 0.51-1

- **Maintainability Rating on New Code**
  - **Definition:** SQALE rating for new code.
  - **Calculation Method:** Uses the same scale as the general maintainability rating.

- **Effort to Reach Maintainability Rating A**
  - **Definition:** Effort required to achieve an 'A' maintainability rating.
  
- **Blocker Issues**

  - **Definition:** Total count of issues categorized as "blocker".

- **Critical Issues**

  - **Definition:** Total count of issues categorized as "critical".

- **Major Issues**

  - **Definition:** Total count of issues categorized as "major".

- **Minor Issues**

  - **Definition:** Total count of issues categorized as "minor".

- **Info Issues**

  - **Definition:** Total count of issues categorized as "info".

- **Total Issues**

  - **Definition:** Aggregate count of all issues, including blocker, critical, major, minor, and info.

- **New Blocker Issues**

  - **Definition:** Count of new "blocker" issues since the last scan.

- **New Critical Issues**

  - **Definition:** Count of new "critical" issues since the last scan.

- **New Major Issues**

  - **Definition:** Count of new "major" issues since the last scan.

- **New Minor Issues**

  - **Definition:** Count of new "minor" issues since the last scan.

- **New Info Issues**

  - **Definition:** Count of new "info" issues since the last scan.

- **New Issues**

  - **Definition:** Total count of new issues found in the latest scan across all categories.
