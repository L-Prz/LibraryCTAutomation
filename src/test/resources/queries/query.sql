select * from books;

select * from users;

select count(id) from users;

select count(distinct id) from users;

select count(*) from book_borrow where is_returned=0;