            if(isLoging) {
                memberDB.put(id,false);
                loginCount--;
            }
            memberDB.remove(id);
        }

        return memberDB.size();
    }

    // 5. 등록 회원이고 로그아웃 상태라면 로그인 처리. 최종 로그인 회원 수 반환.
    private static int login(String id) {
        if(memberDB.containsKey(id)) {
            boolean isLogin = memberDB.get(id);

            if(!isLogin) {
                memberDB.put(id,true);
                loginCount++;
            }
        }

        return loginCount;
    }

    // 6. 로그인 된 회원이라면 로그아웃 처리. 최종 로그인 회원 수 반환.
    private static int logout(String id) {
        if(memberDB.containsKey(id) && memberDB.get(id)) {
            memberDB.put(id,false);
            loginCount--;
        }

        return loginCount;
    }

}