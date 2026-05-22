package designpattern.coreJava.behavioralpattern.statepattern.document.state;

import designpattern.coreJava.behavioralpattern.statepattern.document.Document;

public class DraftDocumentState implements DocumentState{

    @Override
    public void edit(Document document) {
        System.out.println("In draft Editing is allowed");
        System.out.println(document.getDocumentDetail());
    }

    @Override
    public void publish(Document document) {
        System.out.println("Publishing Document!!!");
        System.out.println(document.getDocumentDetail());
        document.setCurrentState(new PublishedDocumentState());
    }
}
