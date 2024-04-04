-- 코드를 입력하세요
SELECT left(product_code,2) as CATEGORY,count(PRODUCT_ID) as PRODUCTS 
from product
group by left(product_code,2)
order by product_code