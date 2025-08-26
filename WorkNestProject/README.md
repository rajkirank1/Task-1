WorkNest - Spring MVC + JSP + Hibernate (minimal skeleton)
--------------------------------------------------------------
What's included:
- Maven WAR project (pom.xml)
- Spring configuration (applicationContext.xml, dispatcher-servlet.xml)
- Entities: User, Task, Comment
- DAO / Service / Controller layers (basic skeleton)
- JSP views for login/register, admin and user dashboards, task details

How to run:
1. Update src/main/webapp/WEB-INF/applicationContext.xml datasource properties for your DB.
2. Create a MySQL database named 'worknestdb' or change URL in applicationContext.xml.
3. Build with: mvn clean package
4. Deploy the generated worknest.war to Tomcat (or other servlet container) and start.
5. Access at: http://localhost:8080/worknest/

Notes & Limitations:
- This is a minimal skeleton to get started. Passwords are stored as plain text (for demo only) - you MUST add hashing for production.
- Error handling, form validation, security, and advanced features are omitted for brevity.
- Task status update logic and admin management endpoints are simplified and need to be extended.

Feel free to ask me to expand any part (user management UI, REST endpoints, authentication, unit tests, Dockerfile, etc.).
