package designpattern.coreJava.behavioralpattern.statepattern;

import designpattern.coreJava.behavioralpattern.statepattern.state.DraftDocumentState;

public class Driver {
    public static void main(String[] args) {
        Document document = new Document();
        DocumentDetail documentDetail = new DocumentDetail("title1","description1","content 1");
        document.edit(documentDetail);
        document.publish();
        document.edit(new DocumentDetail("title2","description2","content 2"));
        document.setCurrentState(new DraftDocumentState());
        document.edit(new DocumentDetail("title3","description3","content 3"));
        document.publish();
    }
}
