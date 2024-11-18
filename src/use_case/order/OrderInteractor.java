package use_case.order;

import entity.Order;
import entity.Book;
import Repository.OrderRepository;
import Repository.BookRepository;

public abstract class OrderInteractor implements OrderInputBoundary {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final OrderOutputBoundary outputBoundary;

    public OrderInteractor(OrderRepository orderRepository, BookRepository bookRepository, OrderOutputBoundary outputBoundary) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public OrderOutputData placeOrder(OrderInputData inputData) {
        // Fetch the book by ID
        Book book = bookRepository.findByID(inputData.getBookId());
        if (book == null) {
            return new OrderOutputData(false, "Book not found.");
        }

        // Create a new order with the provided book and buyer details
        Order order = new Order(book, inputData.getBuyer(), "Pending");
        orderRepository.save(order);

        OrderOutputData outputData = new OrderOutputData(true, "Order placed successfully.");
        outputBoundary.presentOrderResult(outputData);
        return outputData;
    }

    @Override
    public OrderOutputData cancelOrder(Integer orderId) {
        Order order = orderRepository.findByID(orderId);
        if (order == null) {
            return new OrderOutputData(false, "Order not found.");
        }

        order.setStatus("Canceled");
        orderRepository.save(order);

        return new OrderOutputData(true, "Order canceled successfully.");
    }

    @Override
    public OrderOutputData completeOrder(Integer orderId) {
        Order order = orderRepository.findByID(orderId);
        if (order == null) {
            return new OrderOutputData(false, "Order not found.");
        }

        order.setStatus("Completed");
        orderRepository.save(order);

        return new OrderOutputData(true, "Order completed successfully.");
    }
}