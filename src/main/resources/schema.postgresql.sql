CREATE TABLE IF NOT EXISTS students (
    id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT,
    school TEXT,
    eligibility BOOLEAN,
    age INTEGER,
    phoneNumber TEXT,
    graduation DATE,
    plan TEXT,
    aptitude TEXT,
    dedication TEXT,
    passion TEXT,
    basecamp TEXT
);