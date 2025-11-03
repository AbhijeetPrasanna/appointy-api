-- create unique index if not exists (run once)
ALTER TABLE bookings
ADD UNIQUE INDEX uq_booking_date_start (date, start_time);

-- seed (idempotent)
INSERT INTO users (id, name, email) VALUES (1,'Alice','alice@example.com')
  ON DUPLICATE KEY UPDATE id=id;
INSERT INTO users (id, name, email) VALUES (2,'Bob','bob@example.com')
  ON DUPLICATE KEY UPDATE id=id;

INSERT INTO bookings (date, start_time, duration_minutes, user_id)
VALUES ('2025-10-30','10:00:00',30,1)
ON DUPLICATE KEY UPDATE id=id;
