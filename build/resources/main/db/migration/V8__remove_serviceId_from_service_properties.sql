ALTER TABLE "ServiceProperties"
DROP CONSTRAINT IF EXISTS "FK_ServiceProperties_Service";
ALTER TABLE "ServiceProperties"
DROP COLUMN "ServiceId";
