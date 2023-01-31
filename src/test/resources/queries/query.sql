select * from books;

select * from users;

select count(id) from users;

select count(distinct id) from users;

select count(*) from book_borrow where is_returned=0;

select name from book_categories;

select count(id) from books where book_category_id=(select id from book_categories where name like 'Fantasy')y;