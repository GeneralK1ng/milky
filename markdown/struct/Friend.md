# 好友
| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int64 | 好友 QQ 号 |
| qid | string | 好友 QID（**可选**） |
| nickname | string | 好友昵称 |
| sex | enum (string) | 性别，可能值：`male`, `female`, `unknown` |
| remark | string | 好友备注 |
| category | [FriendCategory](../struct/FriendCategory.md) | 好友分组（**可选**） |

