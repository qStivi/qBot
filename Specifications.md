# qBot

## Definitions

- **Server** / **Guild** are synonymous and refer to Discord servers.
- The **Runner** is the Person executing / running / Administrating the bot instance.

## Description

## Handling Secrets

Secrets should be handled some kind of configuration file. The file should
be created at startup. If it already exists the existing file and secrets
should be loaded. When secrets are missing the Runner should be prompted
to enter the missing secrets.

## Reaction Role(s)

Roles should work Guild specific. So every Guild should be able to handle
all Role specific actions separate from other Guilds.

### Role(s) Management

#### Role Channel(s)

#### Create Role(s)

#### Modify Role(s)

#### Delete Role(s)

#### De- / Reactivate Role(s)

### Role(s) assignment

#### Give / Take away Role(s) from other User

#### Give / Take away Role(s) from Self
