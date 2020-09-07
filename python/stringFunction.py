# 문자열 관련 함수 다뤄 보기
mystring = 'Hello python'

print('길이 : ', len(mystring))
print('포함 갯수 : ', mystring.count('o'))
print('검색 위치 : ', mystring.find('e'))
print('검색 위치2 : ', mystring.find('o', 6))
print('검색 위치3 : ', mystring.rfind('o'))

print('문자열 치환1 : ', mystring.replace('l', 't'))
print('문자열 치환2 : ', mystring.replace('l', 't', 1))
print('문자열 치환3 " ', mystring.replace('l', 'blue'))

# sep 옵션은 기본값이 띄어 쓰기
# 띄어 쓰기를 하지 않으려고 sep=''을 사용
mystring = '   가나    다라    '
print('공백 제거 1 :[', mystring.strip(), ']', sep='')
print('공백 제거 2 :[', mystring.lstrip(), ']', sep='')
print('공백 제거 3 :[', mystring.rstrip(), ']', sep='')

# strip() 함수는 기본값으로 공백을 제거하는 데, 임의의 문자를 지정도 가능
mystring = 'xxxHello'
print('공백 제거 4 : [', mystring.strip('x'), ']', sep='')

mystring = 'hello python'

print('대문자 : ', mystring.upper())
print('소문자 : ', mystring.lower())
print('첫 글자만 대문자', mystring.capitalize())

# delimiter: 문자열을 나눠주는 구분자
# split 함수는 기본값으로 공백을 이용하여 문자 분리
print('문자열 분리 1 : ', mystring.split())

# split 함수는 사용자가 문자열을 지정하면 지정한 문자를 이용하여 분리
mystring = '소녀시대/빅뱅/원더걸스'
print('문자열 분리 2 : ', mystring.split('/'))

mystring = 'hello_python.xls'

print('시작 여부 : ', mystring.startswith('H'))
print('종료 여부 : ', mystring.endswith('.ppt'))

# 메소드 체이닝
# 대소문자 구분하지 않고, h로 시작합니까?
print('시작 여부 : ', mystring.lower().startswith('H'))

mylist = ['삼성', '엘지', 'sk']
print('#'.join(mylist))

str = input('문자 입력') # Korea
pos = 2

# 인덱싱: 인덱스를 이용하여 특정 위치의 요소를 1개 추출해 내는 것
munja = str[pos] # 인덱싱(중요)
print(munja)

# be동사 is로 시작하는 함수들은 참 또는 거짓을 반환해준다.
print('대문자 여부 :', munja.isupper())
print('소문자 여부 :', munja.islower())
print('숫자 여부 :', munja.isdigit())

# 프로그램 내부에서 아스키 코드로 변경된 다음, 비교 연산이 이루어 짐
print(munja > 's')

print(munja >= 'A' and munja <= 'Z')
print(munja >= 'a' and munja <= 'z')
print(munja >= '0' and munja <= '9')

# ord 함수: 문자를 아스키 코드로 바꿔주는 함수
print(ord(munja))
print(ord('A'))
print(ord('a'))
print(ord('0'))







