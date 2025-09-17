insert into "Organizations" ( "Name", "Voen", "ContactPerson")
SELECT * FROM (
                  VALUES
                      ('Azintelecom', '123456789', 'John Doe'),
                      ('Merkezi bank', '987654321', 'Jane Smith'),
                      ('Pasha', '123498765', 'Alice Brown')
              ) AS t(name, voen, contactperson)
WHERE NOT EXISTS (SELECT 1 FROM "Organizations");

INSERT INTO "Services" ("Name", "Description", "Url", "ApplicationUrl")
SELECT * FROM (
                  VALUES
                      ('Auth Service', 'Authentication and Authorization', 'http://localhost:8081', 'http://localhost:8081/api/A'),
                      ('Payment Service', 'Handles all payment transactions', 'http://localhost:8082', 'http://localhost:8082/api/B'),
                      ('Notification Service', 'Sends emails and SMS notifications', 'http://localhost:8083', 'http://localhost:8083/api/C')
              ) AS t("Name", "Description", "Url", "ApplicationUrl")
WHERE NOT EXISTS (SELECT 1 FROM "Services");

INSERT INTO "ProjectStatuses" ("Name", "Description")
SELECT * FROM (
                  VALUES
                      ('aktiv', 'aktiv'),
                      ('Deaktiv', 'Deaktiv')
              ) AS t("Name", "Description" )
WHERE NOT EXISTS (SELECT 1 FROM "ProjectStatuses");

INSERT INTO "ServiceProperties" ("PropertyName", "ServiceId")
SELECT * FROM (
                  VALUES
                      ('Name', 1),
                      ('Surname', 2),
                      ('MiddelName', 3)
              ) AS t("PropertyName", "ServiceId" )
WHERE NOT EXISTS (SELECT 1 FROM "ServiceProperties");

INSERT INTO "OrganizationProjects" ("Name", "Description","AuthorizationKey","OrganizationId","ProjectStatusId")
SELECT * FROM (
                  VALUES
                      ('Sima', 'Sima Registration','Abscds3252',1,1),
                      ('Merkezi Bank','Programming department', 'bchscjcsjbs2536',2,1),
                      ('Pasha Insurance','Check insurance','ujuujfh43r233', 3,1)
              ) AS t("Name", "Description","AuthorizationKey","OrganizationId","ProjectStatusId")
WHERE NOT EXISTS (SELECT 1 FROM "OrganizationProjects");



