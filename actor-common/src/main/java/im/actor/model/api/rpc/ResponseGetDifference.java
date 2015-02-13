package im.actor.model.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.model.droidkit.bser.Bser;
import im.actor.model.droidkit.bser.BserValues;
import im.actor.model.droidkit.bser.BserWriter;

import java.io.IOException;

import im.actor.model.network.parser.*;

import java.util.List;
import java.util.ArrayList;

import im.actor.model.api.*;

public class ResponseGetDifference extends Response {

    public static final int HEADER = 0xc;

    public static ResponseGetDifference fromBytes(byte[] data) throws IOException {
        return Bser.parse(new ResponseGetDifference(), data);
    }

    private int seq;
    private byte[] state;
    private List<User> users;
    private List<Group> groups;
    private List<ContactRecord> contacts;
    private List<DifferenceUpdate> updates;
    private boolean needMore;

    public ResponseGetDifference(int seq, byte[] state, List<User> users, List<Group> groups, List<ContactRecord> contacts, List<DifferenceUpdate> updates, boolean needMore) {
        this.seq = seq;
        this.state = state;
        this.users = users;
        this.groups = groups;
        this.contacts = contacts;
        this.updates = updates;
        this.needMore = needMore;
    }

    public ResponseGetDifference() {

    }

    public int getSeq() {
        return this.seq;
    }

    public byte[] getState() {
        return this.state;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public List<ContactRecord> getContacts() {
        return this.contacts;
    }

    public List<DifferenceUpdate> getUpdates() {
        return this.updates;
    }

    public boolean needMore() {
        return this.needMore;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.seq = values.getInt(1);
        this.state = values.getBytes(2);
        List<User> _users = new ArrayList<User>();
        for (int i = 0; i < values.getRepeatedCount(3); i++) {
            _users.add(new User());
        }
        this.users = values.getRepeatedObj(3, _users);
        List<Group> _groups = new ArrayList<Group>();
        for (int i = 0; i < values.getRepeatedCount(6); i++) {
            _groups.add(new Group());
        }
        this.groups = values.getRepeatedObj(6, _groups);

//        List<ContactRecord> _contacts = new ArrayList<ContactRecord>();
//        for (int i = 0; i < values.getRepeatedCount(7); i ++) {
//            _contacts.add(new ContactRecord());
//        }
//        this.contacts = values.getRepeatedObj(7, _contacts);
        this.contacts = new ArrayList<ContactRecord>();

        List<DifferenceUpdate> _updates = new ArrayList<DifferenceUpdate>();
        for (int i = 0; i < values.getRepeatedCount(4); i++) {
            _updates.add(new DifferenceUpdate());
        }
        this.updates = values.getRepeatedObj(4, _updates);
        this.needMore = values.getBool(5);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.seq);
        if (this.state == null) {
            throw new IOException();
        }
        writer.writeBytes(2, this.state);
        writer.writeRepeatedObj(3, this.users);
        writer.writeRepeatedObj(6, this.groups);
        writer.writeRepeatedObj(7, this.contacts);
        writer.writeRepeatedObj(4, this.updates);
        writer.writeBool(5, this.needMore);
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
