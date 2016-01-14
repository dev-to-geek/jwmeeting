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

/**
 * Class: MeetingScheduleBuilderStateException
 *
 * @author Mircha Emanuel `ryuujin` D'Angelo
 * @version 1
 */
public class MeetingScheduleBuilderStateException extends Exception {
    public static final String defaultMessage = "Lo stato di MeetingSchedulerBuilder non è coerente.";
    static final long serialVersionUID = 7818375824346090155L;
    private final MeetingScheduleBuilder meetingScheduleBuilder;

    public MeetingScheduleBuilderStateException(MeetingScheduleBuilder meetingScheduleBuilder) {
        this.meetingScheduleBuilder = meetingScheduleBuilder;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(defaultMessage).append("\n");
        if (meetingScheduleBuilder.isDateNull()) {
            sb.append("meeting date cannot be null\n");
        }
        if (meetingScheduleBuilder.isTimeNull()) {
            sb.append("meeting time cannot be null\n");
        }
        if (meetingScheduleBuilder.isMeetingChunksEmpty()) {
            sb.append("meeting chunks list cannot be emptyl\n");
        }
        return sb.toString();
    }

    @Override
    public String getLocalizedMessage() {
        return getMessage();
    }
}

    