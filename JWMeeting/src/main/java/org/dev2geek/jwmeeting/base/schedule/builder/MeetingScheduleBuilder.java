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
import org.dev2geek.jwmeeting.base.schedule.MeetingChunk;
import org.dev2geek.jwmeeting.base.schedule.MeetingSchedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedHashSet;

/**
 * Class: MeetingScheduleBuilder
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

    public MeetingScheduleBuilder addMeetingChunk(MeetingChunk meetingChunk) {
        log.debug("addMeetingChunk({})", meetingChunk);
        if (meetingChunk != null) {
            meetingChunks.add(meetingChunk);
        }
        return this;
    }

    public MeetingScheduleBuilder setDate(LocalDate date) {
        log.debug("setDate({})", date);
        this.meetingDate = date;
        return this;
    }

    public MeetingScheduleBuilder setTime(LocalTime time) {
        log.debug("setTime({})", time);
        this.meetingTime = time;
        return this;
    }

    public MeetingScheduleBuilder setDateTime(LocalDateTime dateTime) {
        log.debug("setDateTime({})", dateTime);
        if (dateTime != null) {
            this.meetingTime = dateTime.toLocalTime();
            this.meetingDate = dateTime.toLocalDate();
        }
        return this;
    }

    public MeetingSchedule create() throws MeetingScheduleBuilderStateException {
        if (meetingDate == null || meetingTime == null || meetingChunks.isEmpty()) {
            throw new MeetingScheduleBuilderStateException(this);
        }

        return new MeetingSchedule(meetingDate, meetingTime, meetingChunks);
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

    