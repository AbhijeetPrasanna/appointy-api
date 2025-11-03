ALTER TABLE bookings
ADD CONSTRAINT uq_booking_date_start UNIQUE (date, start_time);

INSERT INTO users (id, name, email) VALUES (1,'Alice','alice@example.com')
ON CONFLICT (id) DO NOTHING;
INSERT INTO users (id, name, email) VALUES (2,'Bob','bob@example.com')
ON CONFLICT (id) DO NOTHING;

INSERT INTO bookings (date, start_time, duration_minutes, user_id)
VALUES ('2025-10-30','10:00:00',30,1)
ON CONFLICT (date, start_time) DO NOTHING;
