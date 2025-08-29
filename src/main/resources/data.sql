-- =================================================================
-- 공연장(PerformanceHall) 테이블 데이터 삽입
-- =================================================================
INSERT INTO performance_hall (venue)
VALUES ('소극장 A'), -- ID: 1
       ('중형홀 B'), -- ID: 2
       ('대형홀 C');
-- ID: 3

-- =================================================================
-- 좌석(Seat) 테이블 데이터 삽입
-- =================================================================

-- 1. 소극장 A (ID: 1) 좌석 데이터 - 총 1석
-- -----------------------------------------------------------------
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
VALUES (1, 'VIP', 1, 1);


-- 2. 중형홀 B (ID: 2) 좌석 데이터 - 총 500석
-- -----------------------------------------------------------------
-- VIP 섹션 (50석) : 5행 10열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
WITH RECURSIVE NumberSequence (seq) AS (SELECT 1
                                        UNION ALL
                                        SELECT seq + 1
                                        FROM NumberSequence
                                        WHERE seq < 50)
SELECT 2,
       'VIP',
       FLOOR((seq - 1) / 10) + 1 AS row_no,
       ((seq - 1) % 10) + 1 AS col_no
FROM NumberSequence;

-- R 섹션 (200석) : 10행 20열 (6행부터 시작)
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
WITH RECURSIVE NumberSequence (seq) AS (SELECT 1
                                        UNION ALL
                                        SELECT seq + 1
                                        FROM NumberSequence
                                        WHERE seq < 200)
SELECT 2,
       'R',
       FLOOR((seq - 1) / 20) + 6 AS row_no,
       ((seq - 1) % 20) + 1 AS col_no
FROM NumberSequence;

-- S 섹션 (250석) : 10행 25열 (16행부터 시작)
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
WITH RECURSIVE NumberSequence (seq) AS (SELECT 1
                                        UNION ALL
                                        SELECT seq + 1
                                        FROM NumberSequence
                                        WHERE seq < 250)
SELECT 2,
       'S',
       FLOOR((seq - 1) / 25) + 16 AS row_no,
       ((seq - 1) % 25) + 1 AS col_no
FROM NumberSequence;


-- 3. 대형홀 C (ID: 3) 좌석 데이터 - 총 1,000석
-- -----------------------------------------------------------------
-- VIP 섹션 (100석) : 10행 10열
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
WITH RECURSIVE NumberSequence (seq) AS (SELECT 1
                                        UNION ALL
                                        SELECT seq + 1
                                        FROM NumberSequence
                                        WHERE seq < 100)
SELECT 3,
       'VIP',
       FLOOR((seq - 1) / 10) + 1 AS row_no,
       ((seq - 1) % 10) + 1 AS col_no
FROM NumberSequence;

-- R 섹션 (400석) : 20행 20열 (11행부터 시작)
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
WITH RECURSIVE NumberSequence (seq) AS (SELECT 1
                                        UNION ALL
                                        SELECT seq + 1
                                        FROM NumberSequence
                                        WHERE seq < 400)
SELECT 3,
       'R',
       FLOOR((seq - 1) / 20) + 11 AS row_no,
       ((seq - 1) % 20) + 1 AS col_no
FROM NumberSequence;

-- S 섹션 (500석) : 25행 20열 (31행부터 시작)
INSERT INTO seat (performance_hall_id, section, row_no, col_no)
WITH RECURSIVE NumberSequence (seq) AS (SELECT 1
                                        UNION ALL
                                        SELECT seq + 1
                                        FROM NumberSequence
                                        WHERE seq < 500)
SELECT 3,
       'S',
       FLOOR((seq - 1) / 20) + 31 AS row_no,
       ((seq - 1) % 20) + 1 AS col_no
FROM NumberSequence;