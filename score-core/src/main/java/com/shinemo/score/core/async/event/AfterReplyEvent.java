package com.shinemo.score.core.async.event;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AfterReplyEvent {
	
	private Long commentId;

}