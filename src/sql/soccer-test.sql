-- 001. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오.
SELECT * FROM team
ORDER BY team_name ASC;

-- 002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오
SELECT DISTINCT POSITION FROM player;

-- 003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오


-- 004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
SELECT player_name
FROM player
WHERE POSITION = 'GK' AND team_id = 'K02';

-- 004-1. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 아이디를 모를경우
SELECT player_name
FROM player
WHERE POSITION = 'GK' AND team_id = (SELECT team_id FROM team WHERE region_name = '수원')

-- 005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
SELECT player_name
FROM player
WHERE player_name LIKE '고%' AND height >= 170 AND team_id ='K02';

-- 005-1. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 아이디를 모를경우
SELECT player_name
FROM player
WHERE player_name LIKE '고%'
AND height >= 170 AND team_id =(SELECT team_id
								 FROM team t
								 WHERE t.region_name = '수원');

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.
SELECT player_name
FROM player
WHERE position = 'MF'
AND height >= 170
AND height <= 180
AND team_id in (SELECT team_id
					FROM team
					WHERE team_name = '삼성블루윙즈'OR team_name='드래곤즈');


-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
SELECT * FROM team;
SELECT player_name
FROM player
WHERE POSITION = 'GK' AND team_id =(SELECT team_id
												FROM team
												WHERE region_name = '수원');

-- 문제 8
-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오
-- 키와 몸무게가 없으면 "0" 으로 표시하시오
-- 키와 몸무게는 내림차순으로 정렬하시오
SELECT player_name,(SELECT IF(height = ' ',0,height)) , (SELECT IF(weight = ' ',0,weight))
FROM player
WHERE team_id = (SELECT team_id
						FROM team
						WHERE region_name = '서울')
ORDER BY height DESC, weight DESC;

-- 문제 9
-- 서울팀 선수들 이름과 포지션과
-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오
-- BMI는 "NONE" 으로 표시하시오(as bmi)
-- 최종 결과는 이름내림차순으로 정렬하시오
SELECT player_name, POSITION,
(SELECT IF(height = ' ',0,concat(height,'cm')))AS height,
(SELECT IF(weight = ' ',0,concat(weight,'kg')))AS weight,
IFNULL(round(weight/(height/100*height/100)),'NONE') AS BMI
FROM player
WHERE team_id =  (SELECT team_id
						FROM team
						WHERE region_name = '서울')
ORDER BY player_name DESC;

-- full sacn
-- 4개의 테이블을 무두 조인하시오
SELECT * FROM team;
SELECT * FROM player;

SELECT COUNT(*)
FROM stadium s
	JOIN team t ON s.stadium_id = t.stadium_id
	JOIN player p ON t.team_id = p.team_id
	JOIN schedule sc ON s.stadium_id = sc.stadium_id;

-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
-- 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오
SELECT team_name, player_name
FROM team t
	JOIN player p ON t.team_id = p.team_id
WHERE POSITION = 'GK' AND (region_name = '수원' OR region_name = '대전')
ORDER BY team_name, player_name ;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]               [홈구장]
-- 수원삼성블루윙즈   수원월드컵경기장
SELECT CONCAT(region_name,team_name)AS '팀명' ,stadium_name '홈구장'
FROM stadium s
	JOIN team t ON s.stadium_id = t.stadium_id
	WHERE region_name = '수원'
ORDER BY CONCAT(region_name,team_name),CONCAT(region_name,stadium_name);

-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
SELECT height, team_name, player_name,region_name
FROM team t
	JOIN player p ON t.team_id = p.team_id
WHERE (height BETWEEN 180 and 183) AND (region_name = '수원' or region_name = '대전')
ORDER BY height,team_name, player_name;

-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순
SELECT team_name, player_name
FROM team t
	JOIN player p ON t.team_id = p.team_id
WHERE POSITION = ' '
ORDER BY team_name, player_name;

-- 문제 14 스칼라와 조인  사용
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.
SELECT thome.team_name,stadium_name,taway.team_name
FROM stadium s
	JOIN team thome ON s.stadium_id = t.stadium_id
	JOIN team taway ON sc.awayteam_id = taway.team_id
	JOIN schedule sc ON s.stadium_id = sc.stadium_id
WHERE sche_date = 20120317;


SELECT (SELECT t.team_name
		  FROM team t
		  WHERE t.team_id = sc.hometeam_id) hometeam,
		  s.stadium_name,
		 (SELECT t.team_name
		  FROM team t
		  WHERE t.team_id = sc.awayteam_id) awayteam
FROM stadium s
JOIN schedule sc ON s.stadium_id = sc.stadium_id
WHERE sche_date = 20120317;

-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
SELECT(SELECT player_name
		 FROM player p
		 WHERE p.team_id = t.team_id AND position = 'GK' AND region_name ='포항')'선수',
		 CONCAT(t.team_name,' ',t.region_name)'팀이름',
		 stadium_name '스타디움',
		(SELECT sche_date
		 FROM schedule sc
		 WHERE sc.sche_date = 20120317 AND sc.stadium_id = s.stadium_id) '경기날짜'
FROM stadium s
JOIN team t ON s.stadium_id = t.stadium_id
WHERE region_name = '포항';


SELECT player_name , POSITION, CONCAT(t.team_name,' ',t.region_name)'팀이름',stadium_name,sche_date
FROM stadium s
JOIN team t ON s.stadium_id=t.stadium_id
JOIN player p ON t.team_id=p.team_id
JOIN schedule sc ON s.stadium_id=sc.stadium_id
WHERE POSITION ='GK' AND sche_date=20120317 AND region_name='포항';

-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
SELECT stadium_name, sche_date,
(SELECT team_name
  FROM team t
  WHERE t.team_id=sc.hometeam_id)'홈팀',
(SELECT team_name
 FROM team t
 WHERE t.team_id=sc.awayteam_id)'원정팀'
FROM stadium s
JOIN schedule sc ON s.stadium_id = sc.stadium_id
WHERE home_score-away_score >= 3;

-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
-- 경기장 이름, 홈팀
SELECT stadium_name, hometeam_id
FROM stadium s
left JOIN team t ON s.stadium_id=t.stadium_id;


SELECT stadium_name, (select t.team_name
                      from team t
                      where team_id=hometeam_id)
from stadium;

-- 문제 18 페이지네이션 로직을 위한 플레이어 테이블에서 최상단 5개 로우를 출력
SELECT player_name FROM player
order BY 1 LIMIT 0,5;

-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
SELECT team_id,team_name,ROUND(AVG(p.height),2)
FROM team t
JOIN player p USING (team_id)
WHERE p.height !=' '
GROUP BY t.team_id
HAVING ROUND(AVG(p.height),2)< (SELECT AVG(p2.height)
										  FROM team t2
										  JOIN player p2 USING (team_id)
										  WHERE t2.region_name = '인천');

-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
SELECT team_name,player_name,back_no,POSITION
FROM team t
JOIN player p USING (team_id)
WHERE POSITION = 'MF';

-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외
SELECT (SELECT team_name
		  FROM team t
		  WHERE t.team_id=p.team_id)'팀이름',player_name,back_no,POSITION,height
FROM player p
ORDER by height DESC LIMIT 5;

-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)
SELECT p.*
FROM team t
JOIN player p USING (team_id)
WHERE height !=''and p.height < (SELECT ROUND(AVG(p2.height),2)
											 FROM player p2
 					  						 WHERE p2.height !=''AND p2.team_id=p.team_id);

SELECT p.*
FROM player p
JOIN (SELECT p2.team_id,ROUND(AVG(p2.height),2) avg
		FROM player p2
		WHERE p2.height != ''
		GROUP BY p2.team_id) AS t_avg
USING (team_id)
WHERE p.height!='' AND p.height < t_avg.avg;

-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회
SELECT s.stadium_name
from stadium s
JOIN schedule sc USING (stadium_id)
where sc.sche_date like'201205%'
GROUP BY s.stadium_name;








