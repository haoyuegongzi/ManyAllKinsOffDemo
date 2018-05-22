package bonc.demopractice_allkinsoff.bean;

import java.util.List;

/**
 * Created by chenjie on 2017/4/13.
 * TODO：
 */

public class ChildItem {

    private List<DropwnBean> dropwn;
    private List<DataBean> data;
    private List<UserNameBean> userName;

    public List<DropwnBean> getDropwn() {
        return dropwn;
    }

    public void setDropwn(List<DropwnBean> dropwn) {
        this.dropwn = dropwn;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<UserNameBean> getUserName() {
        return userName;
    }

    public void setUserName(List<UserNameBean> userName) {
        this.userName = userName;
    }

    public static class DropwnBean {
        /**
         * donParentId : 1
         * donName : 筛选
         * children : [{"donParentId":"T03","donName":"主资费","children":[{"donParentId":"T009","donName":"存送","children":[],"donCode":"2017052204","donLevel":"3","donId":"T0022"},{"donParentId":"T009","donName":"合约","children":[],"donCode":"2017052203","donLevel":"3","donId":"T0021"},{"donParentId":"T009","donName":"迁转","children":[],"donCode":"2017052202","donLevel":"3","donId":"T0020"},{"donParentId":"T009","donName":"升舱","children":[],"donCode":"2017052202","donLevel":"3","donId":"T0019"}],"donLevel":"2","donId":"T009"},{"donParentId":"T03","donName":"终端","children":[{"donParentId":"T008","donName":"信贷购机","children":[],"donCode":"2017052201","donLevel":"3","donId":"T0018"},{"donParentId":"T008","donName":"迁转购机","children":[],"donCode":"2017052201","donLevel":"3","donId":"T0017"},{"donParentId":"T008","donName":"和包购机","children":[],"donCode":"2017052200","donLevel":"3","donId":"T0016"},{"donParentId":"T008","donName":"保底购机","children":[],"donCode":"2017052200","donLevel":"3","donId":"T0015"}],"donLevel":"2","donId":"T008"},{"donParentId":"T03","donName":"流量","children":[{"donParentId":"T007","donName":"流量副卡","children":[],"donCode":"2017051804","donLevel":"3","donId":"T0014"},{"donParentId":"T007","donName":"叠加包","children":[],"donCode":"2017051804","donLevel":"3","donId":"T0013"},{"donParentId":"T007","donName":"小时包","children":[],"donCode":"2017051803","donLevel":"3","donId":"T0012"},{"donParentId":"T007","donName":"流量包","children":[],"donCode":"2017051803","donLevel":"3","donId":"T0011"}],"donLevel":"2","donId":"T007"},{"donParentId":"T03","donName":"宽带","children":[{"donParentId":"T006","donName":"手机+","children":[],"donCode":"2017051802","donLevel":"3","donId":"T0010"},{"donParentId":"T006","donName":"全家亲","children":[],"donCode":"2017051801","donLevel":"3","donId":"T0009"},{"donParentId":"T006","donName":"爱家","children":[],"donCode":"2017051800","donLevel":"3","donId":"T0008"},{"donParentId":"T006","donName":"优家","children":[],"donCode":"2017051800","donLevel":"3","donId":"T0007"}],"donLevel":"2","donId":"T006"}]
         * donLevel : 1
         * donId : T03
         */

        private String donParentId;
        private String donName;
        private String donLevel;
        private String donId;
        private List<ChildrenBeanX> children;

        public String getDonParentId() {
            return donParentId;
        }

        public void setDonParentId(String donParentId) {
            this.donParentId = donParentId;
        }

        public String getDonName() {
            return donName;
        }

        public void setDonName(String donName) {
            this.donName = donName;
        }

        public String getDonLevel() {
            return donLevel;
        }

        public void setDonLevel(String donLevel) {
            this.donLevel = donLevel;
        }

        public String getDonId() {
            return donId;
        }

        public void setDonId(String donId) {
            this.donId = donId;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX {
            /**
             * donParentId : T03
             * donName : 主资费
             * children : [{"donParentId":"T009","donName":"存送","children":[],"donCode":"2017052204","donLevel":"3","donId":"T0022"},{"donParentId":"T009","donName":"合约","children":[],"donCode":"2017052203","donLevel":"3","donId":"T0021"},{"donParentId":"T009","donName":"迁转","children":[],"donCode":"2017052202","donLevel":"3","donId":"T0020"},{"donParentId":"T009","donName":"升舱","children":[],"donCode":"2017052202","donLevel":"3","donId":"T0019"}]
             * donLevel : 2
             * donId : T009
             */

            private String donParentId;
            private String donName;
            private String donLevel;
            private String donId;
            private List<ChildrenBean> children;

            public String getDonParentId() {
                return donParentId;
            }

            public void setDonParentId(String donParentId) {
                this.donParentId = donParentId;
            }

            public String getDonName() {
                return donName;
            }

            public void setDonName(String donName) {
                this.donName = donName;
            }

            public String getDonLevel() {
                return donLevel;
            }

            public void setDonLevel(String donLevel) {
                this.donLevel = donLevel;
            }

            public String getDonId() {
                return donId;
            }

            public void setDonId(String donId) {
                this.donId = donId;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * donParentId : T009
                 * donName : 存送
                 * children : []
                 * donCode : 2017052204
                 * donLevel : 3
                 * donId : T0022
                 */

                private String donParentId;
                private String donName;
                private String donCode;
                private String donLevel;
                private String donId;
                private List<?> children;

                public String getDonParentId() {
                    return donParentId;
                }

                public void setDonParentId(String donParentId) {
                    this.donParentId = donParentId;
                }

                public String getDonName() {
                    return donName;
                }

                public void setDonName(String donName) {
                    this.donName = donName;
                }

                public String getDonCode() {
                    return donCode;
                }

                public void setDonCode(String donCode) {
                    this.donCode = donCode;
                }

                public String getDonLevel() {
                    return donLevel;
                }

                public void setDonLevel(String donLevel) {
                    this.donLevel = donLevel;
                }

                public String getDonId() {
                    return donId;
                }

                public void setDonId(String donId) {
                    this.donId = donId;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }
    }

    public static class DataBean {
        /**
         * preName : 4G手机节
         * preJoinum : 570万
         * preIncost : 667万
         * preState : 0
         * preCode : 2017051801
         * preUserNum : 157万
         * preTime : 2017.03.01-2017.05.08
         */

        private String preName;
        private String preJoinum;
        private String preIncost;
        private String preState;
        private String preCode;
        private String preUserNum;
        private String preTime;

        public String getPreName() {
            return preName;
        }

        public void setPreName(String preName) {
            this.preName = preName;
        }

        public String getPreJoinum() {
            return preJoinum;
        }

        public void setPreJoinum(String preJoinum) {
            this.preJoinum = preJoinum;
        }

        public String getPreIncost() {
            return preIncost;
        }

        public void setPreIncost(String preIncost) {
            this.preIncost = preIncost;
        }

        public String getPreState() {
            return preState;
        }

        public void setPreState(String preState) {
            this.preState = preState;
        }

        public String getPreCode() {
            return preCode;
        }

        public void setPreCode(String preCode) {
            this.preCode = preCode;
        }

        public String getPreUserNum() {
            return preUserNum;
        }

        public void setPreUserNum(String preUserNum) {
            this.preUserNum = preUserNum;
        }

        public String getPreTime() {
            return preTime;
        }

        public void setPreTime(String preTime) {
            this.preTime = preTime;
        }
    }

    public static class UserNameBean {
        /**
         * userId : 8570
         * userName : 江波
         */

        private String userId;
        private String userName;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
