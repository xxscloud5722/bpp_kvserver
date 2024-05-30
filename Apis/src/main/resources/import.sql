
PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for pair
-- ----------------------------
CREATE TABLE IF NOT EXISTS "pair" (
                        "id" integer PRIMARY KEY AUTOINCREMENT,
                        "key" text NOT NULL DEFAULT '',
                        "value" text NOT NULL DEFAULT '',
                        "description" text NOT NULL DEFAULT '',
                        "create_by" integer NOT NULL DEFAULT 0,
                        "create_time" DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        "update_by" integer NOT NULL DEFAULT 0,
                        "update_time" DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        "remarks" TEXT NOT NULL DEFAULT '',
                        "is_delete" integer NOT NULL DEFAULT 0
);


-- ----------------------------
-- Indexes structure for table pair
-- ----------------------------
CREATE UNIQUE INDEX "main"."un_key"
    ON "pair" (
               "key" ASC
        );
