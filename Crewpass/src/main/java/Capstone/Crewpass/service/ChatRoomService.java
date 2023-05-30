package Capstone.Crewpass.service;

import Capstone.Crewpass.dto.ChatRoomInfo;
import Capstone.Crewpass.entity.DB.ChatRoom;
import Capstone.Crewpass.repository.ChatRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    @Autowired
    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    // 채팅방 생성
    @Transactional
    public Integer createChatRoom(ChatRoom chatRoom) {
        chatRoomRepository.save(chatRoom);
        return chatRoom.getChatRoomId();
    }

    // 모집글 아이디로 채팅방 아이디 찾기
    public Integer findChatRoomIdByRecruitmentId(Integer recruitmentId) {
        ChatRoom chatRoom = chatRoomRepository.findByRecruitmentId(recruitmentId);
        return chatRoom.getChatRoomId();
    }

    // 채팅방 정보 조회
    public ChatRoomInfo findInfoByChatroomId(Integer chatroomId) {
        return chatRoomRepository.findInfoByChatroomId(chatroomId);
    }

//    // 동아리 - 채팅방 리스트 조회
//    public List<> findChatRoomListByCrewId(Integer crewId) {
//        return chatRoomRepository.findAll
//    }
}
