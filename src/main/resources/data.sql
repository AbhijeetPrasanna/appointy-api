INSERT INTO users (name, email) VALUES ('Alice','alice@example.com'), ('Bob','bob@example.com');

INSERT INTO bookings (date, start_time, duration_minutes, user_id)
VALUES
  ('2025-10-30', '10:00:00', 30, 1),
  ('2025-10-30', '12:30:00', 30, 2),
  ('2025-10-31', '09:00:00', 60, 1);
