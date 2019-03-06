# Code Overview

### The Base Camp Coding Academy interview process using Spring. With @matt2tech & @rayturner677.

We used Java and a framework called Spring to replicate the Base Camp Coding Academy student application and reviewing the applications from the administrator side.



### It first has a home page.

- The home page uses HTML and CSS to style it to look similar to the Base Camp Coding Academy's website (www.basecampcodingacademy.org).
- It has a landing controlled called **LandingController.java** so when it makes a GET request to that page, it will direct to that page.
- It also has a template called **landing.mustache** used to style the home page correctly.



### It has a static CSS file.

- It has a custom CSS file in a directory called **static** so we can use our own custom CSS along with bootstrap classes, it is called **main.css**.
- Also in the static directory we have an **images** directory to keep all of our pictures in (BCCA logos).



### Then It has 2 sides.

### 1. The Student Application Side.

- The student application side has the form where the student can apply and answer all the respected questions. It has form validation so they have to put in valid data and if they don't put in anything at all it won't submit to the database. 
- It then submits the data from the inputs into the database to save it. We use postgresql to do this in **PostgresStudentRepository.java**.
- We also used **schema.postgresql.sql** to create the tables and put them into the database.
- We also use a file called **StudenForm.java** in a directory called **forms** to set up what makes a student and setting up the object.
- After the student applies, it has a screen that has resources for the student to look at before they come in for an interview. It also thanks the student for applying. That is in a file called **resources.mustache** and it has a controller to tell it where to go when it makes a **GET** request, that controller is called **ResourcesController.java**.

### 2. The Administrator Side.

- The administrator side has a controller that handles all the sorting. Like sorting in ABC order, newest to oldest, and oldest to newest. This file is called **InterviewController.java**. 
- The interview page shows the students and shows the user whether the student is eligible or not. 
- The template for the page that shows all the students is called **interview.mustache.**
- You can then click on the respected student to show their details. The details are their answers to the questions and if they are eligible. This template is called **applicant.mustache**. It is also included in the **InterviewController.java**.



### The application is also accessible on mobile.