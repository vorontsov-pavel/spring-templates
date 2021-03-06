
CREATE TABLE IF NOT EXISTS oauth_access_token (
  token_id          VARCHAR(256),
  token             BYTEA,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name         VARCHAR(256),
  client_id         VARCHAR(256),
authentication    BYTEA,
  refresh_token     VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
  token_id       VARCHAR(256),
  token          BYTEA,
authentication BYTEA
);

CREATE TABLE IF NOT EXISTS oauth_client_details (
  client_id               VARCHAR(256) PRIMARY KEY,
  resource_ids            VARCHAR(256),
  client_secret           VARCHAR(256),
  scope                   VARCHAR(256),
  authorized_grant_types  VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities             VARCHAR(256),
  access_token_validity   INTEGER,
  refresh_token_validity  INTEGER,
  additional_information  VARCHAR(4096),
  autoapprove             VARCHAR(256)
);

INSERT INTO public.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES ('client_id', 'api-2', 'client_secret', 'read,write', 'password,refresh_token', null, 'CLIENT', null, null, null, null);