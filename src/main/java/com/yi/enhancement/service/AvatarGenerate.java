package com.yi.enhancement.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author: lyric
 * @date: 2021/8/25 21:36
 * @description:
 */
@Service
public class AvatarGenerate {
    private static int avatarNumber = 0;

    @Value("${comment.1}")
    private String avatar1;
    @Value("${comment.2}")
    private String avatar2;
    @Value("${comment.3}")
    private String avatar3;
    @Value("${comment.4}")
    private String avatar4;
    @Value("${comment.5}")
    private String avatar5;
    @Value("${comment.6}")
    private String avatar6;
    @Value("${comment.7}")
    private String avatar7;
    @Value("${comment.8}")
    private String avatar8;
    @Value("${comment.9}")
    private String avatar9;
    @Value("${comment.10}")
    private String avatar10;
    @Value("${comment.11}")
    private String avatar11;
    @Value("${comment.12}")
    private String avatar12;

    public synchronized String getAvatar() {

        switch (avatarNumber) {
            case 0: {
                avatarNumber++;
                return avatar1;
            }
            case 1: {
                avatarNumber++;
                return avatar2;
            }
            case 2: {
                avatarNumber++;
                return avatar3;
            }
            case 3: {
                avatarNumber++;
                return avatar4;
            }
            case 4: {
                avatarNumber++;
                return avatar5;
            }
            case 5: {
                avatarNumber++;
                return avatar6;
            }
            case 6: {
                avatarNumber++;
                return avatar7;
            }
            case 7: {
                avatarNumber++;
                return avatar8;
            }
            case 8: {
                avatarNumber++;
                return avatar9;
            }
            case 9: {
                avatarNumber++;
                return avatar10;
            }
            case 10: {
                avatarNumber++;
                return avatar11;
            }
            case 11: {
                avatarNumber = 0;
                return avatar12;
            }
            default: {
                return avatar1;
            }
        }
    }
}
