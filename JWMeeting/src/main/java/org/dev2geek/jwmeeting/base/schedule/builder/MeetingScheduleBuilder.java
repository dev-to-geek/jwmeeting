/*******************************************************************************
 * This file is part of JWMeeting.
 * <p>
 * JWMeeting is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * JWMeeting is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with JWMeeting.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.dev2geek.jwmeeting.base.schedule.builder;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dev2geek.jwmeeting.base.schedule.chunks.MeetingChunk;
import org.dev2geek.jwmeeting.base.schedule.MeetingSchedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashSet;

/**
 * Class: MeetingScheduleBuilder
 * <p>
 * With this you can instantiate your MeetingSchedule
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 */
public final class MeetingScheduleBuilder {

    private static final Logger log = LogManager.getLogger(MeetingScheduleBuilder.class);

    private LocalDate meetingDate;
    private LocalTime meetingTime;
    private String meetingName;
    private LinkedHashSet<MeetingChunk> meetingChunks;

    public MeetingScheduleBuilder() {
        log.debug("MeetingScheduleBuilder init");
        meetingChunks = new LinkedHashSet<>(10);
    }

    /**
     * Adds an assignement to this meeting. Order of inserting matters.
     *
     * @param meetingChunk the assignement
     * @return MeetingScheduleBuilder instance
     */
    public MeetingScheduleBuilder addMeetingChunk(MeetingChunk meetingChunk) {
        log.debug("addMeetingChunk({})", meetingChunk);
        if (meetingChunk != null) {
            meetingChunks.add(meetingChunk);
        }
        return this;
    }

    /**
     * sets the date of this meeting
     *
     * @param date the date of this meeting
     * @return MeetingScheduleBuilder instance
     */
    public MeetingScheduleBuilder setDate(LocalDate date) {
        log.debug("setDate({})", date);
        this.meetingDate = date;
        return this;
    }

    /**
     * sets the time of this meeting
     *
     * @param time the time of this meeting
     * @return MeetingScheduleBuilder instance
     */
    public MeetingScheduleBuilder setTime(LocalTime time) {
        log.debug("setTime({})", time);
        this.meetingTime = time;
        return this;
    }

    /**
     * sets the date and the time of this meeting
     *
     * @param dateTime the date and time
     * @return MeetingScheduleBuilder instance
     */
    public MeetingScheduleBuilder setDateTime(LocalDateTime dateTime) {
        log.debug("setDateTime({})", dateTime);
        if (dateTime != null) {
            this.meetingTime = dateTime.toLocalTime();
            this.meetingDate = dateTime.toLocalDate();
        }
        return this;
    }

    /**
     * It builds up the MeetingSchedule object. If any param insterted is not valid
     * it throws an exception
     *
     * @return MeetingSchedule instance
     * @throws MeetingScheduleBuilderStateException
     */
    public MeetingSchedule create() throws MeetingScheduleBuilderStateException {
        if (!isValid()) {
            throw new MeetingScheduleBuilderStateException(this);
        }

        return new MeetingSchedule(meetingDate, meetingTime, meetingChunks);
    }

    /**
     * it tells you if this builder can create the instance of MeetingScheduler
     *
     * @return true if is in valid state, false otherwise
     */
    public boolean isValid() {
        return !(meetingDate == null || meetingTime == null || meetingChunks.isEmpty());
    }

    boolean isDateNull() {
        return meetingDate == null;
    }

    boolean isTimeNull() {
        return meetingTime == null;
    }

    boolean isMeetingChunksEmpty() {
        return meetingChunks.isEmpty();
    }
}

    