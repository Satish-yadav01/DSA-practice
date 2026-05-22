package designpattern.coreJava.behavioralpattern.statepattern.document.state;

import designpattern.coreJava.behavioralpattern.statepattern.document.Document;

public interface DocumentState {
    void edit(Document document);
    void publish(Document document);
}
