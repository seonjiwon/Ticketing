-- PerformanceHall 테이블 데이터
INSERT INTO performance_hall (venue) VALUES
                                         ('소극장 A'),           -- ID: 1 (1석)
                                         ('중형홀 B'),           -- ID: 2 (500석)
                                         ('대형홀 C'),           -- ID: 3 (1,500석)
                                         ('메가홀 D');           -- ID: 4 (3,000석)

-- Seat 테이블 데이터

-- 1. 소극장 A (1석) - VIP 1석
INSERT INTO seat (performance_hall_id, section, row_no, col_no) VALUES
    (1, 'VIP', 1, 1);

-- 2. 중형홀 B (500석) - VIP 50석, R 200석, S 250석
-- VIP 섹션 (50석) - 5행 10열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 2, 'VIP',
       FLOOR((seq - 1) / 10) + 1 as row_num,
       ((seq - 1) % 10) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns
    LIMIT 50
    ) t;

-- R 섹션 (200석) - 10행 20열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 2, 'R',
       FLOOR((seq - 1) / 20) + 6 as row_num,  -- 6행부터 시작
       ((seq - 1) % 20) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns a
    CROSS JOIN information_schema.columns b
    LIMIT 200
    ) t;

-- S 섹션 (250석) - 10행 25열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 2, 'S',
       FLOOR((seq - 1) / 25) + 16 as row_num,  -- 16행부터 시작
       ((seq - 1) % 25) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns a
    CROSS JOIN information_schema.columns b
    LIMIT 250
    ) t;

-- 3. 대형홀 C (1,500석) - VIP 150석, R 600석, S 750석
-- VIP 섹션 (150석) - 10행 15열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 3, 'VIP',
       FLOOR((seq - 1) / 15) + 1 as row_num,
       ((seq - 1) % 15) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns a
    CROSS JOIN information_schema.columns b
    LIMIT 150
    ) t;

-- R 섹션 (600석) - 20행 30열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 3, 'R',
       FLOOR((seq - 1) / 30) + 11 as row_num,  -- 11행부터 시작
       ((seq - 1) % 30) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns a
    CROSS JOIN information_schema.columns b
    CROSS JOIN information_schema.columns c
    LIMIT 600
    ) t;

-- S 섹션 (750석) - 25행 30열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 3, 'S',
       FLOOR((seq - 1) / 30) + 31 as row_num,  -- 31행부터 시작
       ((seq - 1) % 30) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns a
    CROSS JOIN information_schema.columns b
    CROSS JOIN information_schema.columns c
    LIMIT 750
    ) t;

-- 4. 메가홀 D (3,000석) - VIP 300석, R 1200석, S 1500석
-- VIP 섹션 (300석) - 15행 20열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 4, 'VIP',
       FLOOR((seq - 1) / 20) + 1 as row_num,
       ((seq - 1) % 20) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns a
    CROSS JOIN information_schema.columns b
    CROSS JOIN information_schema.columns c
    LIMIT 300
    ) t;

-- R 섹션 (1,200석) - 30행 40열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 4, 'R',
       FLOOR((seq - 1) / 40) + 16 as row_num,  -- 16행부터 시작
       ((seq - 1) % 40) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns a
    CROSS JOIN information_schema.columns b
    CROSS JOIN information_schema.columns c
    CROSS JOIN information_schema.columns d
    LIMIT 1200
    ) t;

-- S 섹션 (1,500석) - 30행 50열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
SELECT 4, 'S',
       FLOOR((seq - 1) / 50) + 46 as row_num,  -- 46행부터 시작
       ((seq - 1) % 50) + 1 as col_num
FROM (
    SELECT ROW_NUMBER() OVER () as seq
    FROM information_schema.columns a
    CROSS JOIN information_schema.columns b
    CROSS JOIN information_schema.columns c
    CROSS JOIN information_schema.columns d
    LIMIT 1500
    ) t;