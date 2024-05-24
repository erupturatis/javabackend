Database description
 - The database manages interns which apply to different projects which are part of different departments. We have the following tables. Applications are new people who want to join a project inside a department
 - Admin ( can log in to the system )
   - id, username, password
 - Department
   - id, name, description
 - Project
   - id, name, description, department_id
 - Member
   - id, name, email
 - Project_Member
   - project_id, member_id
 - Skill
   - id, name
 - Member_Skill
   - member_id, skill_id
 - Application
   -  id, project_id, name, motivation
 - Application_Skill
   - application_id, skill_id 
 
I have this database, I need 
 - Login view where only the admins can log  
 - Admin view which shows all departments and their members + their projects
 - Department view which shows the members in a department, the projects of that specific department. 
 - Project view which shows info about the project, the members, the present aggregate skills from all members and the applications
 - Member view which shows basic info about the member + their skills
 - Application view which shows the application and the skills of the applicant