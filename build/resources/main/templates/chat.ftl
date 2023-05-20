<!DOCTYPE html>
<html>
<head>
  <title>WebSocket Chat</title>
  <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/main.css" rel="stylesheet">
  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/sockjs-client/sockjs.min.js"></script>
  <script src="/webjars/stomp-websocket/stomp.min.js"></script>
  <script src="/chat.js"></script>
</head>
<body>
<div id="main-content" class="container">
  <div class="row">
    <div class="col-md-12 space-bottom10">
      <form class="form-inline">
        <div class="form-group">
          <label for="from">Name?</label>
          <input type="text" id="from" class="form-control" placeholder="enter your name...">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button id="connect" class="btn btn-default" type="submit">Connect</button>
        <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">Disconnect</button>
      </form>
    </div>
  </div>
  <div class="row space-bottom10">
    <form>
      <div class="col-md-2">
        <select name="topic" id="topic" class="form-control">
          <option>Lifestyle</option>
          <option>Travel</option>
          <option>Career</option>
        </select>
      </div>
      <div class="col-md-6">
        <input type="text" id="text" class="form-control" placeholder="enter messageChat ...">
      </div>
      <div class="col-md-4">
        <button id="send" class="btn btn-default" type="submit">Send</button>
      </div>
    </form>
  </div>
  <div class="row">
    <div class="col-md-12">
      <table id="conversation" class="table table-striped">
        <thead>
        <tr>
          <th width="10%">From</th>
          <th width="15%">Topic</th>
          <th width="60%">Message</th>
          <th width="10%">Time</th>
        </tr>
        </thead>
        <tbody id="messages">
        </tbody>
      </table>
    </div>
  </div>
</div>

<script>
  $(document).ready(function() {
    $("form").submit(function(event) {
      event.preventDefault();
      var name = $("#from").val();
      console.log(name);
      $.ajax({
        type: "POST",
        url: "/send-message",
        data: JSON.stringify({ name: name }),
        contentType: "application/json",
        success: function(response) {
          console.log("Message sent successfully");
        },
        error: function(error) {
          console.error("Error sending message: " + error);
        }
      });
    });
  });
</script>

</body>
</html>
