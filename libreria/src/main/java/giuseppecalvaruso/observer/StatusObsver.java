package giuseppecalvaruso.observer;

import giuseppecalvaruso.factory_file.Book;

public class StatusObsver implements LibraryObserver{
    private int rentedCount = 0;

    @Override
    public void update(String eventType, Book book) {
        if("rent".equals(eventType)){
            rentedCount++;

        } else if("return".equals(eventType)){
            rentedCount--;
        }

        System.out.println("Current rented Books: "+ rentedCount);
    
}}
