# CSC207-Project

## Project Specification for Group #66

### Domain:
The domain of this project is second hand book transaction. This software should allow user to buy or sell second hand bookIds by providing transaction functionalities including account (for both buyers and sellers) registration and management, product (book) posting and order management. Additionally the software could allow user to look for, main.java.view details of, comment on bookIds and add bookIds to shopping carts. An extension to the software functionality could be price drop notification and book recommendation.

### Software specification:
+ Major Features
  - Account registration and management: allow user to register an account to buy and/or sell bookIds after completing their profiles including but not limited to their name, address and contact information.
  - Product posting: allow any registered user to post a product, edit product details and delete product details.
  - Order management: allow user buy a product which generates an order. The order can be completed or cancelled.
+ More Features
  - Search a product by titles, authors, subjects, genres, etc
  - View details of a product including book condition, summary, table of contents, and first few pages.
  - Add a book to shopping cart
+ Bonus Features
  - Notify buyers when there's a price decrease
  - Recommend a book to buyer (Exp: Mario asks for futuristic scientific fiction that must contains aliens. Gpt will return 10 bookIds related to this topic and write few sentences recommending each book)

### User stories:
- User story #1: Tom wants to sell some bookIds he has read but no longer wishes to read in the future. (**assigned to Jing**)
- User story #2: Lucas wants to buy some entertaining bookIds but have no idea which book fits her need. She wants to search for book  based on genre and would like to read a book's table of contents and first few pages to decide if she really wants it. (**assigned to Bosco**)
- User story #3: Louis wants to buy some text bookIds at lower price because he doesn't afford new ones. He doesn't mind if the book contains notes and drawings. He would also like to receive a price drop notification on bookIds he added to shopping cart. (**assigned to Tianao**)
- User story #4: Britney wants to buy some bookIds for her kids but she doesn't know which one her kids really like. So she want to pick a few and store them in the cart for later use. (**assigned to Eric**)
- Team user story: Jack would like to sell some textbooks to other students because he bought extras and can't return the book and request for refund. (**assigned to Team**)
### Entities:
- User: id, username, password, address, contact_information, cart_items (list of productId)
- Book: id, image_url, title, authors, language, translators, subject, description, samples (table of contents and first few pages)
- Product: id, book_id, seller_id, book_condition, price, sold
- Order: id, buyer_id, seller_id, product_id, order_time, order_status, delivery_address

**\* Note that a product must corresponds a book instance. A book instance is created by accessing Google Books API**

### Database:
Here are how the database is designed to record the data, entities should rely on them but shouldn't be identical to their database conterparts.


|                                                        |                                                              |
|--------------------------------------------------------|--------------------------------------------------------------|
| <strong>user</strong> <br/> ![user](image/user.png)    | <strong>product</strong> <br/> ![product](image/product.png) |
| <strong>order</strong> <br/> ![order](image/order.png) |                                                              |

### Proposed API:
- Google Books API: use Google Books API for searching book details.

### Meeting Schedules:
Meetings: every Saturday offline or online meetings

### Team Members
| Team Members | Github Username |
|--------------|-----------------|
| Jing Wei     | Wesley-GITT     |
| Bosco Zeng   | BoscoZZZ        |
| Tianao       | aotian69        |
| Eric Zhang   | Juntongdalao    |
