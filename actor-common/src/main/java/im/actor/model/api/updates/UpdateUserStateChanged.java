package im.actor.model.api.updates;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.model.droidkit.bser.Bser;
import im.actor.model.droidkit.bser.BserValues;
import im.actor.model.droidkit.bser.BserWriter;
import java.io.IOException;
import im.actor.model.network.parser.*;
import im.actor.model.api.*;

public class UpdateUserStateChanged extends Update {

    public static final int HEADER = 0x64;
    public static UpdateUserStateChanged fromBytes(byte[] data) throws IOException {
        return Bser.parse(new UpdateUserStateChanged(), data);
    }

    private int uid;
    private UserState state;

    public UpdateUserStateChanged(int uid, UserState state) {
        this.uid = uid;
        this.state = state;
    }

    public UpdateUserStateChanged() {

    }

    public int getUid() {
        return this.uid;
    }

    public UserState getState() {
        return this.state;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.uid = values.getInt(1);
        this.state = UserState.parse(values.getInt(2));
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.uid);
        if (this.state == null) {
            throw new IOException();
        }
        writer.writeInt(2, this.state.getValue());
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
