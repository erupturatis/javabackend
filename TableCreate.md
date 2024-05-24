-- Create the Admin table
CREATE TABLE Admin (
id SERIAL PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL
);

-- Create the Department table
CREATE TABLE Department (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
description TEXT
);

-- Create the Project table
CREATE TABLE Project (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
description TEXT,
department_id INT NOT NULL,
FOREIGN KEY (department_id) REFERENCES Department(id)
);

-- Create the Member table
CREATE TABLE Member (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL
);

-- Create the Project_Member table
CREATE TABLE Project_Member (
project_id INT NOT NULL,
member_id INT NOT NULL,
PRIMARY KEY (project_id, member_id),
FOREIGN KEY (project_id) REFERENCES Project(id),
FOREIGN KEY (member_id) REFERENCES Member(id)
);

-- Create the Skill table
CREATE TABLE Skill (
id SERIAL PRIMARY KEY,
name VARCHAR(100) UNIQUE NOT NULL
);

-- Create the Member_Skill table
CREATE TABLE Member_Skill (
member_id INT NOT NULL,
skill_id INT NOT NULL,
PRIMARY KEY (member_id, skill_id),
FOREIGN KEY (member_id) REFERENCES Member(id),
FOREIGN KEY (skill_id) REFERENCES Skill(id)
);

-- Create the Application table
CREATE TABLE Application (
id SERIAL PRIMARY KEY,
project_id INT NOT NULL,
name VARCHAR(100) NOT NULL,
motivation TEXT,
FOREIGN KEY (project_id) REFERENCES Project(id)
);

-- Create the Application_Skill table
CREATE TABLE Application_Skill (
application_id INT NOT NULL,
skill_id INT NOT NULL,
PRIMARY KEY (application_id, skill_id),
FOREIGN KEY (application_id) REFERENCES Application(id),
FOREIGN KEY (skill_id) REFERENCES Skill(id)
);
