import Attachment01Icon from "@untitled-ui/icons-react/build/esm/Attachment01";
import FaceSmileIcon from "@untitled-ui/icons-react/build/esm/FaceSmile";
import Image01Icon from "@untitled-ui/icons-react/build/esm/Image01";
import Link01Icon from "@untitled-ui/icons-react/build/esm/Link01";
import {
  Avatar,
  Button,
  Card,
  CardContent,
  IconButton,
  OutlinedInput,
  Stack,
  SvgIcon,
  useMediaQuery,
} from "@mui/material";
import { useMockedUser } from "src/hooks/use-mocked-user";
import { getInitials } from "src/utils/get-initials";
import { createResourceId } from "src/utils/create-resource-id";

export const SocialPostAdd = (props) => {
  const date = new Date();
  const { createPost, ...other } = props;
  const user = useMockedUser();
  const smUp = useMediaQuery((theme) => theme.breakpoints.up("sm"));

  const onClickPost = () => {
    const postContent = document.getElementById("postContent").value;
    if (!postContent) return;
    const post = {
      user_id: user.id,
      created_at: date.toISOString(),
      parentFeedbackId: null,
      content: postContent,
    };
    createPost(post);
    document.getElementById("postContent").value = "";
  };

  return (
    <Card {...props}>
      <CardContent>
        <Stack alignItems="flex-start" direction="row" spacing={2}>
          <Avatar
            src={`/assets/avatars/${user.avatar}`}
            sx={{
              height: 40,
              width: 40,
            }}
          >
            {getInitials(user.name)}
          </Avatar>
          <Stack spacing={3} sx={{ flexGrow: 1 }}>
            <OutlinedInput
              fullWidth
              multiline
              placeholder="Bạn đang nghĩ gì?"
              rows={3}
              id="postContent"
            />
            <Stack alignItems="center" direction="row" justifyContent="space-between" spacing={3}>
              {/* {smUp && (
                <Stack alignItems="center" direction="row" spacing={1}>
                  <IconButton>
                    <SvgIcon>
                      <Image01Icon />
                    </SvgIcon>
                  </IconButton>
                  <IconButton>
                    <SvgIcon>
                      <Attachment01Icon />
                    </SvgIcon>
                  </IconButton>
                  <IconButton>
                    <SvgIcon>
                      <Link01Icon />
                    </SvgIcon>
                  </IconButton>
                  <IconButton>
                    <SvgIcon>
                      <FaceSmileIcon />
                    </SvgIcon>
                  </IconButton>
                </Stack>
              )} */}
              <div>
                <Button variant="contained" onClick={onClickPost}>
                  Gửi phản hồi
                </Button>
              </div>
            </Stack>
          </Stack>
        </Stack>
      </CardContent>
    </Card>
  );
};
