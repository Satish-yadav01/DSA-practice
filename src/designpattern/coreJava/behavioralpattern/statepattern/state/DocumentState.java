package designpattern.coreJava.behavioralpattern.statepattern.state;

import designpattern.coreJava.behavioralpattern.statepattern.Document;

public interface DocumentState {
    void edit(Document document);
    void publish(Document document);
}
