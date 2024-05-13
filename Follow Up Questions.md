# Follow Up Questions
## 1. How long did you spend on the test? What would you add if you had more time?
I spent about 7 hours to complete the test, including the documentation. I would do an integration with database, authentication and more methods like delete order, edit order, etc.

## 2. What was the most useful feature that was added to the latest version of your chosen language? Please include a snippet of code that shows how you've used it.
JDK 21 is the latest long-term support release of Java SE Platform. I wasn't up to date with all the new features of Java 21, but researching the Java documentation I saw about Virtual Threads, which has this value:
 - **Accelerates application development productivity such as apps targeted for cloud environments by introducing Virtual threads, which are lightweight threads that dramatically reduce the effort of writing, maintaining, and observing high-throughput concurrent applications.**

## 3. What did you find most difficult?
I spent more time implementing the method to apply the promotions (‎ShoppingServiceImpl::applyPromotions), this method has the most complex business logic. 

## 4. What mechanism did you put in place to track down issues in production on this code? If you didn’t put anything, write down what you could do.
I implemented some unit tests, it is a good start to track issues, but if I spent more time on the code I would put some loggs to track important events, errors, warnings and informational messages.

## 5. The Wiremock represents one source of information. We should be prepared to integrate with more sources. List the steps that we would need to take to add more sources of items with diferent formats and promotions.
* We would need to implement a comprehensive standard for all data sources, for example, there are different types of promotions but the same model covers all types, it would be the same with different sources.
* We may need to implement converters, different sources may provide different types of files, names, etc., so it is necessary to have adapters to standardize this

## Written and verbal communication skills play a pivotal role in our culture and are key to success within our organization. Some individuals excel in written communication, while others shine in verbal interactions. We believe in providing you with an opportunity to demonstrate proficiency in both areas.

### Select one of the questions below and submit your answer before your interview!
#### 1. Share a recent judgment call you've made within the past 12 months that couldn't be thoroughly analyzed beforehand. Focus on a business-related issue. Whether it was a significant decision or a smaller one, describe the situation, the alternatives you considered, and your decision-making process. Explain why you chose the judgment call you did over the alternatives.
I was responsible for working with the project manager in the delivery of one of the company's projects to the client, the project was to digitally collect user acceptance to carry out and store data from financial history queries (the description is short but the business rules are complex).
However, in the middle of the delivery process the project manager went on vacation, as it was my first most significant project in this company my boss expected that I would ask for help to deal with the client's doubts and requests (I cannot go into details as they are confidential information), but I didn't need support and I was praised for that, as I showed preparation to deal with the client in a short time at the company.
This was possible because even though it was a new project for me, I sought to delve deeper into the solution that had been developed, I understood the details and this way it was easy to carry out this delivery without support from someone who had been working on the project for longer.


