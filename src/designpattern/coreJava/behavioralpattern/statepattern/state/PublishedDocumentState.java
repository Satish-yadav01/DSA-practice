package designpattern.coreJava.behavioralpattern.statepattern.state;

import designpattern.coreJava.behavioralpattern.statepattern.Document;

public class PublishedDocumentState implements DocumentState{

    @Override
    public void edit(Document document) {
        System.out.println("Document can not edit in Published State, Document is already published!!");
    }

    @Override
    public void publish(Document document) {
        System.out.println("Documents are already published!!");
    }
}
